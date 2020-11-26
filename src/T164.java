import java.util.Arrays;

public class T164 {
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     *
     * 如果数组元素个数小于 2，则返回 0。
     *
     * 示例 1:
     *
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * 示例 2:
     *
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     * 说明:
     *
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-gap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {

        public static int maximumGap(int[] nums) {
            if (nums.length < 2)
                return 0;

            if (nums.length == 2) {
                return (nums[1] - nums[0]) > 0 ?(nums[1] - nums[0]): (nums[0] - nums[1]);
            }

            int min = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                } else if (nums[i] > max) {
                    max = nums[i];
                }
            }

            int k = max - min + 1;
            System.out.println(k);

            // 这种其实是默认桶大小是1，会产生内存溢出
            int[] tubs = new int[k];

            for (int i: nums) {
                tubs[i - min]++;
            }

            int interval = 0;
            int temp = 0;
            for (int i = 0; i < k; i++) {
                if (tubs[i] != 0) {
                    if ((i - temp) > interval) {
                        interval = i - temp;
                    }
                    temp = i;
                }
            }
            return interval;
        }

        /**
         * 优化的桶排序
         * @param nums
         * @return
         */
        public static int maximumGap2(int[] nums) {
            if(nums.length < 2) {
                return 0;
            }

            int max = nums[0];
            int min = nums[1];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                } else if (nums[i] < min) {
                    min = nums[i];
                }
            }

            //获得桶子之间的间隔
            int d = Math.max((max - min) / (nums.length - 1) ,1);
            int bucketSize = (max - min) / d + 1;

            int[][] bucket = new int[bucketSize][2];
            //初始化桶子最大最小值为 -1
            for (int i = 0; i < bucketSize; i++) {
                bucket[i][0] = -1;
                bucket[i][1] = -1;
            }

            //得到每个桶的最大最小值
            for(int i: nums) {
                int id = (i - min) / d;
                if (bucket[id][0] == -1) {
                    bucket[id][0] = bucket[id][1] = i;
                } else {
                    if (i < bucket[id][0]) {
                        bucket[id][0] = i;
                    } else if (i > bucket[id][1]) {
                        bucket[id][1] = i;
                    }
                }
            }

            //最大间隔一定出现在桶之间，求得每个桶之间的距离（下一个桶的最小值 - 上一个桶的最大值）
            int interval = 0;
            int temp = bucket[0][1];
            for (int i = 1; i < bucketSize; i++) {
                if (bucket[i][0] != -1) {
                    if(bucket[i][0] - temp > interval) {
                        interval = bucket[i][0] - temp;
                    }
                    temp = bucket[i][1];
                }
            }
            return interval;
        }

        public static void main(String[] args) {
            int[] nums = new int[] {1,10000000};
            int result = maximumGap2(nums);
            System.out.println(result);
        }
    }
}
