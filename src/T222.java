public class T222 {
    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     *
     * 说明：
     *
     * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 示例:
     *
     * 输入:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * 输出: 6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
    }
    class Solution {

        /**
         * 递归暴力破解
         */
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;

            return countNodes(root.left) + countNodes(root.right) + 1;
        }

        /**
         *
         */
        public int countNodes2(TreeNode root) {

            if(root == null)
                return 0;

            int hLeft = getHeight(root.left);
            int hRight = getHeight(root.right);

            // 当左子树高度 == 右子树 高度时，左子树一定是满二叉树  左子树节点个数为 2^hLeft - 1  加上根节点  就是 2^hLeft  位运算加快速度
            // 对右子树进行递归计算
            if (hLeft == hRight) {
                return countNodes2(root.right) + (1 << hLeft);
            }
            // 当左子树高度 != 右子树高度时，说明左子树一定不满，而右子树一定是满二叉树    右子树节点数是 2^hRight - 1  加上根节点  是2^hRight
            // 对左子树进行递归计算
            else {
                return countNodes2(root.left) + (1 << hRight);
            }
        }


        // 利用完全二叉树的特点计算树的深度，最左侧的路径长就是深度
        int getHeight(TreeNode root) {
            int height = 0;
            while (root != null) {
                height ++;
                root = root.left;
            }
            return height;
        }
    }
}
