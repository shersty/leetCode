import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T290 {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean wordPattern(String pattern, String s) {

        Map<String, Character> str2char = new HashMap<>();
        Map<Character, String> char2str = new HashMap<>();

        int m = s.length();
        int left = 0;

        for (int j = 0; j < pattern.length(); j++) {

            char c = pattern.charAt(j);

            if (left >= m) {
                return false;
            }

            int right = left;
            while (right < m && s.charAt(right) != ' ') {
                right++;
            }
            String tmp = s.substring(left, right);

            if (str2char.containsKey(tmp) &&  str2char.get(tmp) != c) {
                return false;
            }
            if (char2str.containsKey(c) && !char2str.get(c).equals(tmp)) {
                return false;
            }
            str2char.put(tmp, c);
            char2str.put(c, tmp);
            left = right + 1;
        }
        System.out.println(left);
        return left > m;
    }

    @Test
    public void test() {
        String pattern = "abbs";
        String s = "cat dog dog fish";
        System.out.println(wordPattern(pattern, s));
    }
}
