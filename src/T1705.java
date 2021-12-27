import java.util.PriorityQueue;

public class T1705 {
    /**
     * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后
     * （也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果
     * 此时用 apples[i] == 0 且 days[i] == 0 表示。
     *
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     *
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int eatenApples(int[] apples, int[] days) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
            int n = apples.length, time = 0, ans = 0;
            while (time < n || !q.isEmpty()) {
                if (time < n && apples[time] > 0)
                    q.add(new int[] {time + days[time] - 1, apples[time]});
                while (!q.isEmpty() && q.peek()[0] < time)
                    q.poll();
                if (!q.isEmpty()) {
                    int[] cur = q.poll();
                    if (--cur[1] > 0 && cur[0] > time)
                        q.add(cur);
                    ans++;
                }
                time++;
            }
            return ans;
        }
    }
}
