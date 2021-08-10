public class T743 {
    class Solution {



        public int networkDelayTime(int[][] times, int n, int k) {
            int N = 110, M = 6010;
            int[][] w = new int[N][M];
            int INF = 0x3f3f3f3f;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=n; j++) {
                    w[i][j] = w[j][i] = i == j? 0: INF;
                }
            }
            
            for (int[] time :
                    times) {
                int u = time[0], v = time[1], t = time[2];
                w[u][v] = t;
            }

            for (int p = 1; p <= n; p++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                    }
                }
            }
            
            int ans = 0;

            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, w[k][i]);
            }

            return ans >= INF / 2? -1: ans;
        }
    }
}
