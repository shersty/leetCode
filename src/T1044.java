public class T1044 {
    /**
     * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
     *
     * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public String longestDupSubstring(String s) {
            int r = s.length();
            int l = 0;
            String ans = "";
            while (r >= l) {
                int mid = (r + l) / 2;
                String temp = check(mid, s);
                if("".equalsIgnoreCase(temp)) {
                    r = mid;
                    ans = temp;
                } else {
                    l = mid;
                }
            }
            return ans;
        }

        String check(int length, String s) {

            int n = s.length();
            for (int i = 0; i < n - length - 1; i++) {
                String s1 = s.substring(i, i + length);
                for (int j = i; j < n - length; j++) {
                    String s2 = s.substring(j, j + length);
                    if (s1.equalsIgnoreCase(s2)) {
                        return s1;
                    }
                }
            }

            return "";
        }
    }
}
