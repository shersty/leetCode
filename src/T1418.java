import org.junit.Test;

import java.util.*;


public class T1418 {
    static class Solution {
        public static List<List<String>> displayTable(List<List<String>> orders) {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            List<String> foods = new ArrayList<>();
            for (List<String> order: orders) {
                if (!foods.contains(order.get(2))) {
                    foods.add(order.get(2));
                }
                if (hashMap.containsKey(order.get(1))) {
                    hashMap.get(order.get(1)).add(order.get(2));
                } else {
                    List<String> food = new ArrayList<>();
                    food.add(order.get(2));
                    hashMap.put(order.get(1), food);
                }
            }

            Collections.sort(foods);

            ArrayList<Map.Entry<String, List<String>>> list = new ArrayList<>(hashMap.entrySet());




            List<List<String>> result = new ArrayList<>(new ArrayList<>());
            ArrayList<String> first = new ArrayList<>();
            first.add("Table");
            first.addAll(foods);
            result.add(first);
            for(Map.Entry<String, List<String>> entry: list) {
                ArrayList<String> temp = new ArrayList<>(first.size());
                temp.add(entry.getKey());
                for (int i = 1; i < first.size(); i++) {
                    String count = String.valueOf(Collections.frequency(entry.getValue(), first.get(i)));
                    temp.add(count);
                }
                result.add(temp);
            }

            return result;
        }
    }

    @Test
    public void test() {

    }
}
