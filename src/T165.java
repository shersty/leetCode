import org.junit.Test;

import java.util.Arrays;

public class T165 {
    static class Solution {
        public static int compareVersion(String version1, String version2) {

            String[] versions1 = version1.split("\\.");
            String[] versions2 = version2.split("\\.");
            int i = 0, j = 0;
            while (i < versions1.length || j < versions2.length) {
                int a = 0, b = 0;

                if (i < versions1.length) a = Integer.parseInt(versions1[i++]);
                if (j < versions2.length) b = Integer.parseInt(versions2[j++]);

                if (a != b) return a > b ? 1 : -1;
            }
            return 0;
        }
    }

    @Test
    public void test() {
        String s1 = "1.01";
        String s2 = "1";
        System.out.println(Solution.compareVersion(s1, s2));
    }
}
