import org.junit.Test;

public class T1518 {
    /**
     * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
     *
     * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
     *
     * 请你计算 最多 能喝到多少瓶酒。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/water-bottles
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int numWaterBottles(int numBottles, int numExchange) {
            int countExchange = 0;
            int remain = numBottles;
            while (remain >= numExchange) {
                countExchange += remain / numExchange;
                remain = (remain % numExchange) + (remain / numExchange);
            }
            return numBottles + countExchange;
        }
    }
    @Test
    public void test() {
        System.out.println(Solution.numWaterBottles(15, 4));
    }
}
