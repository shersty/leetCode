import org.junit.Test;

import javax.sound.midi.Soundbank;

public class T_offer_42 {
    static class Solution {
        public static int maxSubArray(int[] nums) {

            int f_i = nums[0];
            int ans = nums[0];

            for(int i = 1; i < nums.length; i++) {
                f_i = Math.max(nums[i], f_i + nums[i]);
                ans = Math.max(f_i, ans);
            }

            return ans;
        }
    }

    @Test
    public void test(){
        int[] test = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Solution.maxSubArray(test));
    }
}
