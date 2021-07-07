import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.*;

public class T726 {
    /**
     * 给定一个化学式formula（作为字符串），返回每种原子的数量。
     *
     * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
     *
     * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
     *
     * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
     *
     * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
     *
     * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
     *
     * 示例 1:
     *
     * 输入:
     * formula = "H2O"
     * 输出: "H2O"
     * 解释:
     * 原子的数量是 {'H': 2, 'O': 1}。
     * 示例 2:
     *
     * 输入:
     * formula = "Mg(OH)2"
     * 输出: "H2MgO2"
     * 解释:
     * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
     * 示例 3:
     *
     * 输入:
     * formula = "K4(ON(SO3)2)2"
     * 输出: "K4N2O14S4"
     * 解释:
     * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
     * 注意:
     *
     * 所有原子的第一个字母为大写，剩余字母都是小写。
     * formula的长度在[1, 1000]之间。
     * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-atoms
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {

        static HashMap<String, Integer> result = new HashMap<>();

        public static String countOfAtoms2(String formula) {
            getAtoms(formula, 1);
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
            Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry: list) {
                if (entry.getValue() == 1) {
                    sb.append(entry.getKey());
                }else {
                    sb.append(entry.getKey()).append(entry.getValue());
                }
            }
            return sb.toString();
        }

        public static void getAtoms(String part, int times) {
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (c == '(') {
                    int start = part.indexOf('(');
                    int end = part.lastIndexOf(')');
                    int nums = end;
                    while (nums < part.length() - 1 && part.charAt(nums+1) >= '0' && part.charAt(nums+1) <= '9') {
                        nums = nums + 1;
                    }
                    int newTimes = 1;
                    if (nums > end) {
                        newTimes = Integer.parseInt(part.substring(end + 1, nums + 1));
                    }
                    i = nums;
                    getAtoms(part.substring(start + 1, end), newTimes * times);
                }else if (c >= 'A' && c <= 'Z'){
                    int start = i;
                    int end = start;
                    while (end < part.length() - 1 && part.charAt(end + 1) >= 'a' && part.charAt(end + 1) <= 'z') {
                        end = end + 1;
                    }
                    int nums = end;
                    while (nums < part.length() - 1 &&  part.charAt(nums+1) >= '0' && part.charAt(nums+1) <= '9') {
                        nums = nums + 1;
                    }
                    int newTimes = 1;
                    if (nums > end) {
                        newTimes = Integer.parseInt(part.substring(end + 1, nums + 1));
                    }
                    i = nums;

                    System.out.println(part.substring(start, end + 1));

                    if (result.containsKey(part.substring(start, end + 1))){
                        result.put(part.substring(start, end + 1), result.get(part.substring(start, end + 1)) + times*newTimes);
                    } else {
                        result.put(part.substring(start, end + 1), times*newTimes);
                    }

                }
            }
        }




    }

    @Test
    public void test() {
        String test = "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14";
        System.out.println(Solution.countOfAtoms2(test));
    }
}
