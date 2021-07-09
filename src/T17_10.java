import org.junit.Test;

import java.util.Arrays;

public class T17_10 {
    static class Solution {

        // 摩尔投票
        public static int majorityElement(int[] nums) {

            int major = -1;
            int count = 0;

            for (int num: nums) {
                if (count == 0) {
                    major = num;
                    count = 1;
                } else {
                    count += num == major ? 1: -1;
                }
            }

            count = 0;
            for (int num: nums) {
                if (num == major){
                    count++;
                }
            }

            return count > nums.length/2? major: -1;
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{1,2,5,9,5,9,5,5,5};
        System.out.println(Solution.majorityElement(test));
    }
}
