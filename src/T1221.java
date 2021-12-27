import org.junit.Test;

public class T1221 {
    static class Solution {
        public static int balancedStringSplit(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int result = 0;
            for (int i = 0; i < n; i++){
                char t = chars[i];
                int count = 1;
                for(int j = i + 1; j < n; j++) {
                    i++;
                    count = chars[j] == t? count+1: count-1;
                    if (count == 0) {
                        break;
                    }
                }
                result++;
            }
            return result;
        }
    }


    @Test
    public void test() {
        String s = "RLRRRLLRLL";
        System.out.println(Solution.balancedStringSplit(s));
    }

}
