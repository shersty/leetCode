import org.junit.Test;

import java.util.*;

public class T49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        boolean isAdd = false;

        for (String s : strs) {
            for (List<String> r : result) {
                String res = r.get(0);
                if (s.length() != res.length()) {
                    continue;
                }

                char[] a = s.toCharArray();
                char[] b = res.toCharArray();

                if (!isTheSame(a, b)) {
                    continue;
                }
                isAdd = true;
                r.add(s);
            }

            if (!isAdd) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.add(newList);
                isAdd = false;
            }
        }
        return result;
    }

    private boolean isTheSame(char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test() {
        String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(test));
    }
}
