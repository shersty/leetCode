public class T242 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {

        public static boolean isAnagram(String s, String t) {

            if (s.length() != t.length())
                return false;

            for (char c: s.toCharArray()) {
                if (t.indexOf(c) == -1) {
                    return false;
                }

                t = t.replaceFirst(String.valueOf(c), "");
            }
            return true;
        }

        /**
         * 使用哈希映射
         * @param s
         * @param t
         * @return
         */
        public static boolean isAnagram2(String s, String t) {

            if (s.length() != t.length())
                return false;

            char[] chars = new char[26];

            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a'] ++;
                chars[t.charAt(i) - 'a'] --;
            }

            for (char c: chars) {
                if (c != 0) {
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {
            String s = "anagram";
            String t = "aaangrm";
            System.out.println(isAnagram2(s, t));        }
    }


}
