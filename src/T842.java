import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T842 {
    /**
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     *
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     *
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     *
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     *
     *  
     *
     * 示例 1：
     *
     * 输入："123456579"
     * 输出：[123,456,579]
     * 示例 2：
     *
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     * 示例 3：
     *
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     * 示例 4：
     *
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     * 示例 5：
     *
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     *  
     *
     * 提示：
     *
     * 1 <= S.length <= 200
     * 字符串 S 中只含有数字。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<Integer> splitIntoFibonacci(String S) {

        List<Integer> result = new ArrayList<>();
        backtrack(result, S, 0);
        return result;
    }

    private boolean backtrack(List<Integer> result, String s, int index) {

        // 如果截取完毕并且result的长度大于等于3，则说明得到一个返回
        if (s.length() == index && result.size() >= 3) {
            return true;
        }


        for (int i = index; i < s.length(); i++) {

            // 两位以上数字不能以0开头
            if (i > index && s.charAt(index) == '0') {
                break;
            }

            // 获取本次截取的字符串并转化为long
            long newNum = subDigit(s, index, i + 1);

            // 如果截取到的数字大于Int的最大值，剪枝
            if (newNum > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();

            // 如果截取到的数字大于前边两数的和，剪枝（再往后加会越来越大，更加不符合）
            if (size >= 2 && newNum > (result.get(size - 2) + result.get(size - 1))) {
                break;
            }

            if (size <= 1 || newNum == (result.get(size - 2) + result.get(size - 1))) {

                // 将新得到的数添加到result里面
                result.add((int)newNum);

                // 递归查找
                if (backtrack(result, s, i + 1)) {
                    return true;
                }

                // 如果递归完不符合，则回溯，把添加的数移出
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(String s, int start, int end) {
        return Long.parseLong(s.substring(start, end));
    }

    public int getLength(int a) {
        int length = 1;
        while (a / 10 != 0){
            a /= 10;
            length ++;
        }
        return length;
    }

    @Test
    public void test() {
        String x = "0123";
        System.out.println(splitIntoFibonacci(x));
    }
}
