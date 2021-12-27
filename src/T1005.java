import org.junit.Test;

import java.util.Arrays;

public class T1005 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     *
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     *
     * 以这种方式修改数组后，返回数组 可能的最大和 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int largestSumAfterKNegations(int[] nums, int k) {

            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (k-- >= 0) {
                    if (nums[i] < 0) {
                        if (i == nums.length - 1) {
                            nums[i] = (k & 1) == 1 ? -nums[i]: nums[i];
                            k = 0;
                        } else {
                            nums[i] = -nums[i];
                        }
                    } else {
                        nums[i] = (k & 1) == 1? -nums[i]: nums[i];
                        k = 0;
                    }
                }
                sum+=nums[i];
            }
            return sum;
        }
    }

    @Test
    public void test() {

    }
}
