import org.junit.Test;

public class T1893 {
    static class Solution {
        public static boolean isCovered(int[][] ranges, int left, int right) {
            boolean flag = false;
            for (int i = left; i < right + 1; i++) {
                System.out.println(i);
                for (int[] range :
                        ranges) {
                    if (i >= range[0] && i <= range[1]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        int[][] ranges = new int[][] {
                {1, 2}, {3, 4}, {5, 6}
        };
        int left = 7;
        int right = 7;
        System.out.println(Solution.isCovered(ranges, left, right));
    }
}
