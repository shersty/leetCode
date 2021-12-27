import org.junit.Test;

public class T807 {
    static class Solution {
        public static int maxIncreaseKeepingSkyline(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] rowMax = new int[m];
            int[] colMax = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                    colMax[j] = Math.max(colMax[j], grid[i][j]);
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans += (Math.min(rowMax[i], colMax[j]) - grid[i][j]);
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[][] test = new int[][] {
                {3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}
        };
        System.out.println(Solution.maxIncreaseKeepingSkyline(test));
        System.out.println(true);
        System.out.println(false);
        System.out.println(!true);
        System.out.println(!false);
    }
}
