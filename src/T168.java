import org.junit.Test;

public class T168 {
    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     *
     * 例如：
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     *  
     *
     * 示例 1：
     *
     * 输入：columnNumber = 1
     * 输出："A"
     * 示例 2：
     *
     * 输入：columnNumber = 28
     * 输出："AB"
     * 示例 3：
     *
     * 输入：columnNumber = 701
     * 输出："ZY"
     * 示例 4：
     *
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     *  
     *
     * 提示：
     *
     * 1 <= columnNumber <= 2~31 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                //没有0，所以先减1
                columnNumber--;
                //取余得到当前的个位
                int temp = columnNumber % 26;
                //添加 序号+'A' 的ASCII码 转成char 得到字母
                sb.append((char)(temp + 'A'));
                //整除26计算下一位
                columnNumber/=26;
            }
            //得到的是倒序的，反转一下sb
            sb.reverse();
            return sb.toString();
        }


    }
    @Test
    public void test() {
        int[] test = new int[] {
                10, 25, 701, 2147483647
        };
        for(int i: test) {
            System.out.println(Solution.convertToTitle(i));
        }
    }
}
