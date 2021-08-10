import org.junit.Test;

public class T413 {
    static class Solution {
        public static int numberOfArithmeticSlices(int[] nums) {

            if(nums.length < 3) {
                return 0;
            }
            int count = 0;
            int answer = 0;
            int step = 0, lastStep = nums[1] - nums[0];
            for (int i = 2; i < nums.length; i++) {
                step = nums[i] - nums[i - 1];
                //如果差值相等
                if (step == lastStep) {
                    count++;
                    if (i == nums.length - 1){
                        int x = ((count) * (count + 1))/2;
                        answer += x;
                    }
                } else {
                    if (count >= 1) {
                        int x = ((count) * (count + 1))/2;
                        answer += x;
                    }
                    count = 0;
                }
                lastStep = step;
            }

            return answer;
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Solution.numberOfArithmeticSlices(test));
    }
}
