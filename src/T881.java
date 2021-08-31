import java.util.Arrays;

public class T881 {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int n = people.length;
            int left = 0, right = n -1;
            int count = 0;
            int num = n;
            while (left <= right) {
                if (people[left] + people[right] <= limit) {
                    left++;
                }
                right--;
                count++;
            }
            return count;
        }
    }
}
