import org.junit.Test;

public class T1446 {
    /**
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     */
    static class Solution {
        /**
         * 双指针
         * @param s
         * @return
         */
        public static int maxPower(String s) {
            int n = s.length(), max = 0;
            for (int i = 0; i < n; ) {
                int j = i;
                // 依照题意模拟，右指针一直右移，直到到头或者不是同一字符串
                while (j < n && s.charAt(j) == s.charAt(i))
                    j++;
                max = Math.max(max, j - i);
                i = j;
            }
            return max;
        }

        public static int maxPower2(String s) {
            char[] ss = s.toCharArray();
            int tempMax = 1, max = 0;
            for (int i = 0; i < ss.length - 1; i++) {
                if (ss[i+1] == ss[i]) {
                    tempMax++;
                } else {
                    if (tempMax > max) {
                        max = tempMax;
                    }
                    tempMax = 1;
                }
            }
            return max;
        }
    }
    @Test
    public void test() {
        String test = "bb";
        System.out.println(Solution.maxPower(test));
    }
}
