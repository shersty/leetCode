import java.util.*;

public class T987 {

    class Solution {
//        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

        Map<Integer, Map<Integer,List<Integer>>> resultMap = new TreeMap<Integer, Map<Integer,List<Integer>>>();


        public List<List<Integer>> verticalTraversal(TreeNode root) {

            DFS(root, 0, 0);
            List<List<Integer>> result = new ArrayList<>();
            for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry: resultMap.entrySet()
                 ) {
//                System.out.println(entry.getValue());

                List<Integer> list = new ArrayList<>();
//                Map<Integer, List<Integer>> map = entry.getValue();
                for (Map.Entry<Integer, List<Integer>> e: entry.getValue().entrySet()
                     ) {
                    Collections.sort(e.getValue());
                    list.addAll(e.getValue());
                }
                result.add(list);
            }
            return result;
        }

        public void DFS(TreeNode root, int x, int y) {

            Map<Integer, List<Integer>> yMap = resultMap.getOrDefault(y, new TreeMap<Integer, List<Integer>>());


            List<Integer> list = yMap.getOrDefault(x, new ArrayList<Integer>());
            list.add(root.val);
            yMap.put(x, list);
            resultMap.put(y, yMap);

            if(root.left != null) {
                DFS(root.left, x + 1, y - 1);
            }

            if (root.right != null) {
                DFS(root.right, x + 1, y + 1);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
