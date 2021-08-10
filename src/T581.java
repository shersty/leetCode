import org.junit.Test;

import java.util.Arrays;

public class T581 {
    static class Solution {
        public static int findUnsortedSubarray(int[] nums) {

            int[] sortedNums = nums.clone();
            Arrays.sort(sortedNums);

            int i = 0, j = nums.length - 1;

            while (i <= j && nums[i] == sortedNums[i])
                i++;
            while (i <= j && nums[j] == sortedNums[j])
                j--;

            return j - i + 1;
        }


    }

    @Test
    public void test(){
        int[] test = new int[] {
                2,6,4,8,10,9,15
        };

        System.out.println(Solution.findUnsortedSubarray(test));
    }
}
