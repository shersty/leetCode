import org.junit.Test;

public class T275 {
    static class Solution {
        public static int hIndex(int[] citations) {
            for (int i = citations.length - 1; i >= 0; --i) {
//                if(citations[i] >citations.length) {
//                    continue;
//                }
//                System.out.println(citations[i]);
//                System.out.println(i);

                //如果 当前引用数 大于等于
                if (citations.length - i  <= citations[i] && (i == 0 || citations[i - 1] <= citations.length - i) ) {
                    return citations.length - i;
                }
            }

            return 0;
        }
    }

    @Test
    public void test() {
//        int[] test = new int[]{2,2,3,5,6};
        int[] test = new int[]{100};

        System.out.println(Solution.hIndex(test));
    }
}
