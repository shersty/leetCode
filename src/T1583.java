public class T1583 {

    class Solution {

        int N = 501;
        int[][] ranks = new int[N][N];

        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    ranks[i][preferences[i][j]] = n - j;
                }
            }

            int m = pairs.length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                int x = pairs[i][0], y = pairs[i][1];
                boolean xUnhappy = false, yUnhappy = false;
                for (int j = 0; j < m; j++) {
                    if (i == j)
                        continue;

                    int u = pairs[j][0], v = pairs[j][1];

                    if (!xUnhappy && check(x, y, u, v))
                        xUnhappy = true;

                    if (!yUnhappy && check(y, x, u, v))
                        yUnhappy = true;

                    if (xUnhappy && yUnhappy) {
                        break;
                    }
                }
                if (xUnhappy)
                    ans++;
                if (yUnhappy)
                    ans++;
            }
            return ans;
        }

        boolean check(int x, int y, int u, int v) {

            if (ranks[x][u] > ranks[x][y] && ranks[u][x] > ranks[u][v]) {
                return true;
            }
            if (ranks[x][v] > ranks[x][y] && ranks[v][x] > ranks[v][u]) {
                return true;
            }
            return false;
        }
    }
}
