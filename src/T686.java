public class T686 {
    /**
     * 给定两个字符串a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     *
     * 注意：字符串 "abc"重复叠加 0 次是 ""，重复叠加 1 次是"abc"，重复叠加 2 次是"abcabc"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-string-match
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int ans = 0;
            // 先将a复制到比b长
            while (sb.length() < b.length() && ++ans > 0)
                sb.append(a);
            sb.append(a);
            int idx = sb.indexOf(b);
            if (idx == -1) return -1;
            return idx + b.length() > a.length() * ans ? ans + 1 : ans;
        }
    }
}
