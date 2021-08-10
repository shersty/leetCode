import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class T1337 {
    static class Solution {
        public static int[] kWeakestRows(int[][] mat, int k) {
            int[] result = new int[mat.length];
            int index = 0;
            for (int[] row : mat) {
                int count = 0;
                for (int people :
                        row) {
                    if (people == 0) {
                        break;
                    }
                    count++;
                }
                result[index++] = count;
            }
            Map<Integer, Integer> resultMap = new HashMap<>();
            for (int i = 0; i < result.length; i++) {
                resultMap.put(i, result[i]);
            }
            //这里将map.entrySet()转换成list
            List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(resultMap.entrySet());
            //然后通过比较器来实现排序
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            int[] resultK = new int[k];
            index = 0;
            for (Map.Entry<Integer, Integer> entry: list) {
                if (index >= k)
                    break;
                resultK[index++] = entry.getKey();
            }
            return resultK;
        }

        public static int[] kWeakestRows2(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });

            for (int i = 0; i < m; i++) {

                //二分
                int l = 0, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (mat[i][mid] == 1) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                int cur = mat[i][r] >= 1?  r + 1: r;

                if (priorityQueue.size() == k && priorityQueue.peek()[0] > cur)
                    priorityQueue.poll();

                
            }


            return null;
        }
    }

    @Test
    public void test() {
        int[][] test = new int[][] {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(Solution.kWeakestRows(test, 3)));
    }
}
