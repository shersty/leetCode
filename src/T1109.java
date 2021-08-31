public class T1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {

            int[] answer = new int[n];
            int left, right, num;
            for (int[] flight: bookings
                 ) {
                left = flight[0] - 1;
                right = flight[1] - 1;
                num = flight[2];
                for (int i = left; i <= right; i++) {
                    answer[i] += num;
                }
            }
            
            return answer;
        }
    }
}
