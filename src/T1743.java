import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1743 {
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {

            Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

            for (int[] pair :
                    adjacentPairs) {
                adjacentMap.putIfAbsent(pair[0], new ArrayList<>());
                adjacentMap.putIfAbsent(pair[1], new ArrayList<>());
                adjacentMap.get(pair[0]).add(pair[1]);
                adjacentMap.get(pair[1]).add(pair[0]);
            }

            int[] result = new int[adjacentMap.size()];

            for (Map.Entry<Integer, List<Integer>> entry: adjacentMap.entrySet()) {
                List<Integer> values = entry.getValue();
                if (values.size() == 1) {
                    result[0] = entry.getKey();
                    break;
                }
            }

            result[1] = adjacentMap.get(result[0]).get(0);

            for (int i = 2; i < adjacentMap.size(); i++) {
                List<Integer> values = adjacentMap.get(result[i - 1]);
                // 第n个元素的值 = 第 n-1 个元素的值 的 相邻元素中的一个
                // 而 左相邻元素已经确定是 n-2 个元素的值了，so 取另一个值就ok
                result[i] = values.get(0) == result[i - 2]? values.get(1): values.get(0);
            }
            return result;
        }
    }
}
