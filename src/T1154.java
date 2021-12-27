public class T1154 {
    /**
     * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
     *
     * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/day-of-the-year
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        static int[] preNums = new int[13];
        static {
            for (int i = 1; i < 13; i++) {
                preNums[i] = preNums[i - 1] + nums[i - 1];
            }
        }
        public static int dayOfYear(String date) {
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            boolean isRunYear = year%4==0 && year%100!=0 || year%400==0;
            int ans = month > 2 && isRunYear ? preNums[month - 1] + 1 : preNums[month - 1];
            return ans + day;
        }

    }
}
