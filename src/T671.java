public class T671 {

    class Solution {
        int answer = -1;

        public int findSecondMinimumValue(TreeNode root) {
            dfs(root, root.val);
            return answer;
        }

        void dfs(TreeNode root, int cur) {
            if (root == null) {
                return;
            }
            if (root.val != cur) {
                if (answer == -1) {
                    answer = root.val;
                } else {
                    answer = Math.min(answer, root.val);
                }
                return;
            }
            dfs(root.left, cur);
            dfs(root.right, cur);
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
