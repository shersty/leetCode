public class T709 {
    static class Solution {
        public static String toLowerCase(String s) {
            char[] cc = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (temp >= 'A' && temp <= 'Z') {
                    cc[i] = (char)(temp - 26);
                } else {
                    cc[i] = temp;
                }
            }
            return String.valueOf(cc);
        }
    }
}
