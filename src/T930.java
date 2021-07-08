import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T930 {
    static class Solution {
        public static int numSubarraysWithSum(int[] nums, int goal) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = nums[i];
                if (sum == goal) {
                    count++;
                }
                for (int j = i + 1; j < nums.length && sum <= goal; j++) {
                    sum += nums[j];
                    if (sum == goal) {
                        count++;
                    }
                }
            }
            return count;
        }

        public static int numSubarraysWithSum2(int[] nums, int goal) {

            Map<Integer, Integer> result = new HashMap<>();
            int count = 0;
            int sum = 0;
            for (int num: nums) {
                result.put(sum, result.getOrDefault(sum, 0) + 1);
                sum += num;
                count += result.getOrDefault(sum - goal, 0);
            }
            return count;
        }

        }

    @Test
    public void test() {
        int[] test = new int[] {1, 0, 1, 0, 1};
        System.out.println(Solution.numSubarraysWithSum(test, 2));
        System.out.println(Solution.numSubarraysWithSum2(test, 2));
    }
}
