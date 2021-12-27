import org.junit.Test;

import java.util.Locale;

public class T482 {
    static class Solution {
        public static String licenseKeyFormatting(String s, int k) {
            char[] ss = s.toCharArray();
            int size = ss.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (ss[i] == '-') {
                    continue;
                }
                sb.append(ss[i]);
            }
            System.out.println(sb.toString());
            int mod = sb.length() % k;
            int devide = sb.length() / k;
            StringBuilder sb2 = new StringBuilder();
            if (mod != 0)
                sb2.append(sb.subSequence(0, mod)).append('-');
            for (int i = 0; i < devide; i++) {
                if (i != 0)
                    sb2.append('-');
                sb2.append(sb.subSequence(mod + i*k, mod + (i + 1)*k));
            }
            return sb2.toString().toUpperCase(Locale.ROOT);
        }
    }

    @Test
    public void test() {
        String test = "5F3Z-2e-9-w";
        System.out.println(Solution.licenseKeyFormatting(test, 4));
    }
}
