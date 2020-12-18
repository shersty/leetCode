import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

public class T738 {
    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     * <p>
     * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     * <p>
     * 示例 1:
     * <p>
     * 输入: N = 10
     * 输出: 9
     * 示例 2:
     * <p>
     * 输入: N = 1234
     * 输出: 1234
     * 示例 3:
     * <p>
     * 输入: N = 332
     * 输出: 299
     * 说明: N 是在 [0, 10^9] 范围内的一个整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int i = 1;
        while (i< nums.length && nums[i - 1] <= nums[i]) {
            i++;
        }

        if (i < nums.length) {
            while (i > 0 && nums[i - 1] > nums[i]) {
                nums[i - 1]-=1;
                i--;
            }

            for (int j = i + 1; j < nums.length; j++) {
                nums[j] = '9';
            }
        }
        return Integer.parseInt(new String(nums));
    }

    @Test
    public void test() {
        int test = 332;
        System.out.println(monotoneIncreasingDigits(test));
    }
}
