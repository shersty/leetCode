import java.util.ArrayDeque;
import java.util.Deque;

public class T1609 {
    /**
     * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
     *
     * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
     * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
     * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/even-odd-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            Deque<TreeNode> d = new ArrayDeque<>();
            boolean flag = true;
            d.addLast(root);
            while (!d.isEmpty()) {
                int size = d.size(), prev = flag? 0 : 0x3f3f3f3f;
                while (size-- > 0) {
                    TreeNode node = d.pollFirst();
                    int cur = node.val;
                    if (flag && (cur % 2 == 0 || cur <= prev))
                        return false;
                    if (!flag && (cur % 2 != 0 || cur >= prev))
                        return false;
                    prev = cur;
                    if (node.left != null)
                        d.addLast(node.left);
                    if (node.right != null)
                        d.addLast(node.right);
                }
                flag = !flag;
            }
            return true;
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
