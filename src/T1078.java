import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1078 {
    /**
     * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
     * 其中 second 紧随 first 出现，third 紧随 second 出现。
     *
     * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static String[] findOcurrences(String text, String first, String second) {
            String[] ss = text.split(" ");
            ArrayList<String> ans = new ArrayList<>();
            if (ss.length <= 2) {
                return new String[0];
            }
            for (int i = 1; i < ss.length - 1; i++) {
                String f = ss[i - 1];
                String s = ss[i];
                if (f.equalsIgnoreCase(first) && s.equalsIgnoreCase(second)) {
                    ans.add(ss[i + 1]);
                }
            }
            String[] ansArray = new String[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                ansArray[i] = ans.get(i);
;            }
            return ansArray;
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(125);
        test.add(126);
        test.add(127);
        Integer[] test1 = new Integer[3];
        Integer[] ans1 = test.toArray(test1);
        Integer[] test2 = new Integer[4];
        Integer[] ans2 = test.toArray(test2);
        Integer[] test3 = new Integer[5];
        Integer[] ans3 = test.toArray(test3);
        Integer[] test4 = new Integer[6];
        Integer[] ans4 = test.toArray(test4);
        System.out.println(Arrays.asList(ans1));
        System.out.println(Arrays.asList(ans2));
        System.out.println(Arrays.asList(ans3));
        System.out.println(Arrays.asList(ans4));
        System.out.println(ans1);
        System.out.println(test1);
        System.out.println(ans2);
        System.out.println(test2);
        System.out.println(ans3);
        System.out.println(test3);
        System.out.println(ans4);
        System.out.println(test4);
    }
}
