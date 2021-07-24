public class T1736 {
    class Solution {
        public String maximumTime(String time) {

            char[] times = time.toCharArray();

            if(times[0] == '?') {
                if (times[1] == '?') {
                    times[0] = '2';
                    times[1] = '3';
                } else if (times[1] < '4') {
                    times[0] = '2';
                }else {
                    times[0] = '1';
                }
            } else {
                if (times[1] == '?')
                    times[1] = times[0] == '2'? '3': '9';
            }
            times[3] = times[3] == '?'? '5' : times[3];
            times[4] = times[4] == '?'? '9' : times[4];

            return String.copyValueOf(times);
        }
    }
}
