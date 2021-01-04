import org.junit.Test;

public class T509 {
    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 2) + fib(n - 1);
    }

    /**
     * 滑动数组，记录前两个位置的数即可，不用递归了
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int left = 0;
        int right = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = left + right;
            left = right;
            right = fib;
        }
        return fib;
    }

    @Test
    public void test() {
        int test = 5;
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
            System.out.println(fib2(i));
        }
    }
}
