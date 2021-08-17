public class T551 {
    class Solution {
        public boolean checkRecord(String s) {
            char[] chars = s.toCharArray();

            int countA = 0;
            int countL = 0;
            for (char c :
                    chars) {
                if (c == 'A') {
                    countA++;
                    countL  = 0;
                    if (countA == 2) {
                        return false;
                    }
                } else if (c == 'L') {
                    countL++;
                    if (countL == 3) {
                        return false;
                    }
                } else {
                    countL = 0;
                }
            }
            return true;
        }
    }
}
