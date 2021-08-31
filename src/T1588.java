public class T1588 {
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + arr[i - 1];
            }
            int ans = 0;
            for (int len = 1; len <= n; len += 2) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    ans += sum[r + 1] - sum[l];
                }
            }
            return ans;
        }
    }
}
