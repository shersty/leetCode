import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class T1711 {
    static class Solution {
        public static int countPairs(int[] deliciousness) {


            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < 21; i++) {
                map.put((int) Math.pow(2, i), 0);
            }
            int count = 0;
            for (int i = 0; i < deliciousness.length; i++){
                for (int j = deliciousness.length - 1; j > i ; j--) {
                    if (map.containsKey(deliciousness[i] + deliciousness[j])) {
                        count++;
                    }
                }
            }
            return (int) (count%(Math.pow(10, 9) + 7));
        }

        public static int countPairs2(int[] deliciousness) {
            final int MOD = 1000000007;
            int maxVal = 0;
            for (int val : deliciousness) {
                maxVal = Math.max(maxVal, val);
            }
            int maxSum = maxVal * 2;
            int pairs = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int n = deliciousness.length;
            for (int i = 0; i < n; i++) {
                int val = deliciousness[i];
                for (int sum = 1; sum <= maxSum; sum <<= 1) {
                    int count = map.getOrDefault(sum - val, 0);
                    pairs = (pairs + count) % MOD;
                }
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            return pairs;
        }
    }

    @Test
    public void test () {
        int[] deliciousness = new int[]{1,1,1,3,3,3,7};
        System.out.println(Solution.countPairs(deliciousness));
    }
}
