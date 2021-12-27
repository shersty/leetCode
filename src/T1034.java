import java.util.ArrayDeque;
import java.util.Deque;

public class T1034 {
    /**
     * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
     *
     * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
     *
     * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
     *
     * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coloring-a-border
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] ans = new int[m][n];
            int[][] dirs = new int[][] {
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            };
            Deque<int[]> d = new ArrayDeque<>();
            d.addLast(new int[]{row, col});
            while (!d.isEmpty()) {
                int[] poll = d.pollFirst();
                int x = poll[0], y = poll[1], cnt = 0;
                for (int[] dir :
                        dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                        continue;
                    if (grid[x][y] != grid[nx][ny])
                        continue;
                    else
                        cnt++;
                    if (ans[nx][ny] != 0)
                        continue;
                    d.addLast(new int[]{nx, ny});
                }
                //如果 单元格的四联通单元格都不是边界，那么上色
                ans[x][y] = cnt == 4 ? grid[x][y] : color;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j] == 0) ans[i][j] = grid[i][j];
                }
            }
            return ans;
        }
    }
}
