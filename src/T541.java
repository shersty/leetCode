public class T541 {
    class Solution {
        public String reverseStr(String s, int k) {

            int left = 0, right = k;
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length()/k; i++) {
                if ((i + 1) * k > n) {
                    sb.append(s.substring(left, right));
                }
            }


            return s;
        }
    }
}
