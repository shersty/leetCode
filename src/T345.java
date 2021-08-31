import org.junit.Test;

public class T345 {

    static class Solution {
        public static String reverseVowels(String s) {

            char[] chars = s.toCharArray();

            int left = 0, right = s.length() - 1;

            while (left < right) {

                while (!check(chars[left]) && left < s.length() - 1) {
                    left++;
                }

                while (!check(chars[right]) && right > 0) {
                    right--;
                }

                if (left < right) {
                    System.out.println(left + " " +  right);
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                } else {
                    break;
                }
            }

            return String.copyValueOf(chars);
        }

        public static String reverseVowels2(String s) {

            char[] chars = s.toCharArray();
            int l = 0, r = s.length() - 1;

            while (l < r) {
                if (check(chars[l]) && check(chars[r])) {
                    char temp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = temp;
                    l++;
                    r--;
                }else {
                    if (!check(chars[l]))
                        l++;
                    if (!check(chars[r]))
                        r--;
                }
            }

            return String.valueOf(chars);
        }


            public static boolean check(char c) {
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
                    c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                return true;
            }
            return false;
        }
    }

    @Test
    public void test() {
        String test = "leetcode";

        System.out.println(Solution.reverseVowels2(test));
    }
}
