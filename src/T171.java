import org.junit.Test;

public class T171 {
    static class Solution {
        public static int titleToNumber(String columnTitle) {

            char[] chars = columnTitle.toCharArray();
            int result = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                result += (chars[columnTitle.length() - i - 1] - 'A' + 1) * Math.pow(26, i);
            }
            return result;
        }
    }

    @Test
    public void test() {
        String test = "FXSHRXW";
        System.out.println(Solution.titleToNumber(test));
    }
}
