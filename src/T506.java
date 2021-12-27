import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

public class T506 {

    /**
     * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
     *
     * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
     *
     * 名次第 1 的运动员获金牌 "Gold Medal" 。
     * 名次第 2 的运动员获银牌 "Silver Medal" 。
     * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
     * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
     * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/relative-ranks
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static String[] findRelativeRanks(int[] score) {
            int n = score.length;
            int[] scoreCopy = score.clone();
            Arrays.sort(scoreCopy);
            HashMap<Integer, Integer> scoreIndex = new HashMap<>();
            for (int i = n - 1; i >= 0; i--) {
                scoreIndex.put(scoreCopy[i], n - i - 1);
            }
            String[] ans = new String[n];
            String[] modals = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
            for (int i = 0; i < n; i++) {
                ans[i] = scoreIndex.get(score[i]) < 3? modals[scoreIndex.get(score[i])]: String.valueOf(scoreIndex.get(score[i]) + 1);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[] test = new int[] {
                10,3,8,9,4
        };
        System.out.println(Arrays.toString(Solution.findRelativeRanks(test)));
    }
}
