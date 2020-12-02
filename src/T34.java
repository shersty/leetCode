public class T34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *  
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * 提示：
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, 1};
            }

            int lastIndex = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
                if (nums[i] == target) {
                    lastIndex = i;
                    count++;
                }
            }

            if (lastIndex == -1) {
                return new int[] {-1, 1};
            } else {
                return new int[] {lastIndex - count + 1, lastIndex};
            }
        }

        public static int[] searchRange2(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, 1};
            }

            int leftIndex = binarySearch(nums, target, true);
            int rightIndex = binarySearch(nums, target, false) - 1;

            if (leftIndex <= rightIndex && rightIndex <= nums.length  && nums[leftIndex] == target && nums[rightIndex] == target) {
                return new int[]{leftIndex, rightIndex};
            }
            return new int[] {-1, -1};


        }

        public static int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    answer = mid;
                } else {
                    left = mid + 1;
                }
            }
            return answer;
        }


        public static void main(String[] args) {
            int[] test = new int[] {-109, -108, -108, 5,7,7,8,8,10};
            int target = -108;

            System.out.println(searchRange2(test,target)[0]);
            System.out.println(searchRange2(test,target)[1]);
        }
    }
}
