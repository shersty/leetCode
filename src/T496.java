import org.junit.Test;

public class T496 {
    static class Solution {
        public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

            int m = nums1.length;
            int n = nums2.length;

            int[] ans = new int[m];

            for (int i = 0; i < m; i++) {
                int j = 0;
                while (j < n && nums2[j] != nums1[i]) j++;
                while (j < n && nums2[j] <= nums1[i]) j++;
                ans[i] = j < n? nums2[j] : -1;
            }
            return ans;
        }
    }

    @Test
    public void test(){
        int[] nums1 = new int[] { 4,1,2 };
        int[] nums2 = new int[] { 1,3,4,2 };
        int[] ans = Solution.nextGreaterElement(nums1, nums2);
        for (int i :
                ans) {
            System.out.println(i);
        }
    }
}
