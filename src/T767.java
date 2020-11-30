import java.util.Comparator;
import java.util.PriorityQueue;

public class T767 {
    /**
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * <p>
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: S = "aab"
     * 输出: "aba"
     * 示例 2:
     * <p>
     * 输入: S = "aaab"
     * 输出: ""
     * 注意:
     * <p>
     * S 只包含小写字母并且长度在[1, 500]区间内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorganize-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static String reorganizeString(String S) {
            int[] chars = new int[26];
            for (char c : S.toCharArray()) {
                chars[c - 'a']++;
            }

            int max = 0;
            for (int i : chars) {
                if (i > max) {
                    max = i;
                }
            }

            if (max > S.length() - max + 1) {
                return "";
            }

            // 带优先级的队列，优先弹出出现次数高的字母
            PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> chars[letter2 - 'a'] - chars[letter1 - 'a']);

            for (char c = 'a'; c <= 'z'; c++) {
                if (chars[c - 'a'] > 0) {
                    queue.offer(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (queue.size() > 1) {
                char no1 = queue.poll();
                char no2 = queue.poll();
                sb.append(no1);
                sb.append(no2);
                int index1 = no1 - 'a';
                int index2 = no2 - 'a';
                chars[index1]--;
                chars[index2]--;

                if (chars[index1] > 0) {
                    queue.offer(no1);
                }

                if (chars[index2] > 0) {
                    queue.offer(no2);
                }
            }

            if (queue.size() > 0) {
                sb.append(queue.poll());
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            String test = "aab";
            System.out.println(reorganizeString(test));
        }
    }

}
