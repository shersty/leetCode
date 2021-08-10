import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class T313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {

            Queue<Long> numbers = new PriorityQueue<Long>();
            Set<Long> numberSet = new HashSet<Long>();
            numbers.add(1L);
            numberSet.add(1L);

            while (n-- > 0) {
                long x = numbers.poll();
                if (n == 0) {
                    return (int) x;
                }

                for (int num :
                        primes) {
                    if (!numberSet.contains(x * num)) {
                        numbers.add(x * num);
                        numberSet.add(x * num);
                    }
                }
            }

            return -1;
        }
    }
}
