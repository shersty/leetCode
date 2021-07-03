import org.junit.Test;

import java.util.*;

public class T451 {
    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * "tree"
     * <p>
     * 输出:
     * "eert"
     * <p>
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * 示例 2:
     * <p>
     * 输入:
     * "cccaaa"
     * <p>
     * 输出:
     * "cccaaa"
     * <p>
     * 解释:
     * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     * 示例 3:
     * <p>
     * 输入:
     * "Aabb"
     * <p>
     * 输出:
     * "bbAa"
     * <p>
     * 解释:
     * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     * 注意'A'和'a'被认为是两种不同的字符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static String frequencySort(String s) {
            HashMap<Character, Integer> result = new HashMap();
            for (char c :
                    s.toCharArray()) {
                if (!result.containsKey(c)) {
                    result.put(c, 1);
                } else {
                    result.put(c, result.get(c) + 1);
                }
            }

            StringBuilder sb = new StringBuilder();

            List<Map.Entry<String, Integer>> list = new ArrayList(result.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();
                    //按照value值，从大到小排序
                    return o2.getValue() - o1.getValue();
                    //按照value值，用compareTo()方法默认是从小到大排序
//                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            for (Map.Entry<String, Integer> entry:list
                 ) {
                sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
            }

            return sb.toString();
        }
    }

    @Test
    public void test() {
        String test = "Aabb";
        System.out.println(Solution.frequencySort(test));
    }
}
