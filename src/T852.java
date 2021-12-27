import java.util.Arrays;

public class T852 {
    /**
     * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
     *
     * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
     *
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     * 否则，x 将会向 y 发送一条好友请求。
     *
     * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
     *
     * 返回在该社交媒体网站上产生的好友请求总数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int numFriendRequests(int[] ages) {
            Arrays.sort(ages);
            int ans = 0;
            int n = ages.length;
            for (int k = 0, i = 0, j = 0; k < n; k++) {
                // 寻找左边界，也就是第一个满足的下标
                while (i < k && !check(ages[i], ages[k]))
                    i++;
                // 右边界可以从当前元素自己开始找
                if (j < k) {
                    j = k;
                }
                // 寻找右边界
                while (j < n && check(ages[j], ages[k]))
                    j++;
                if (j > i)
                    ans+= j - i - 1;
            }
            return ans;
        }

        public static boolean check(int x, int y) {
            if (y <= 0.5 * x + 7)
                return false;
            if (y > x)
                return false;
            if (y > 100 && x < 100)
                return false;
            return true;
        }
    }
}
