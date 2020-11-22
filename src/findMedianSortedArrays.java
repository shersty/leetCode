import org.junit.Test;

public class findMedianSortedArrays {
    int[] nums1 = {1,3,7,14,16};
    int[] nums2 = {2};
    @Test
    public void test1(){
       int left1 = 0, left2 = 0;
       int m = nums1.length;
       int n = nums2.length;
       int flag = -1;
       double median = 0;

       for(int i = 0; i < (m + n) / 2; i++){
           if(left1 < m && left2 < n){
               if(nums1[left1] < nums2[left2]){
                   left1++;
                   flag = 1;
               }else {
                   left2++;
                   flag = 2;
               }
           }else if(left1 >= m){
               left2++;
               flag = 2;
           }else {
               left1++;
               flag = 1;
           }
       }
       if((m+n)%2 == 1){
           median = flag ==1? nums2[left2]: nums1[left1];
           System.out.println("奇数");
       }else {
           median = flag ==1? (nums1[left1-1]+nums2[left2])/2.0:(nums1[left1]+nums2[left2-1])/2.0;
           System.out.println("偶数");

       }
        System.out.println(left1);
        System.out.println(left2);
        System.out.println(flag);
        System.out.println(median);
    }

}
