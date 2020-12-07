import org.junit.Test;

import java.util.Arrays;

public class T861 {
    /**
     * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
     * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
     * 返回尽可能高的分数。 
     *
     * 示例：
     * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
     * 输出：39
     * 解释：
     * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
     * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     *  
     * 提示：
     * 1 <= A.length <= 20
     * 1 <= A[0].length <= 20
     * A[i][j] 是 0 或 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int result = m * (1 << (n-1));

        for (int i = 1; i < n; i++) {
            int x = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][0] == 1) {
                    x += A[j][i];
                } else  {
                    x += (1 - A[j][i]);
                }
            }
            result += (Math.max(x, m - x) * (1 << n - i - 1));
        }
        return result;
    }

    @Test
    public void test() {
        int[][] test = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(test));
    }
}
