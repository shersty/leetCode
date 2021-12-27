import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class T17_14 {
    static class Solution {
        public static int[] smallestK(int[] arr, int k) {
            if(arr.length == 0 || k == 0)
                return new int[0];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
            for (int i :
                    arr) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(i);
                } else {
                    int max = priorityQueue.peek();
                    if (i < max) {
                        priorityQueue.poll();
                        priorityQueue.add(i);
                    }
                }
            }
            int[] result = new int[priorityQueue.size()];
            int index = 0;
            while (priorityQueue.size() != 0) {
                result[index++] = priorityQueue.poll();
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{};
        System.out.println(Arrays.toString(Solution.smallestK(test, 0)));
    }
}
