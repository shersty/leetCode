import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T162 {
    static class Solution {
        public static boolean isValidSudoku(char[][] board) {

            Map<Integer, Set<Character>> mapCol = new HashMap<>();
            Map<Integer, Set<Character>> mapRow = new HashMap<>();
            Map<Integer, Set<Character>> mapArea = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                mapArea.put(i, new HashSet<>());
                mapCol.put(i, new HashSet<>());
                mapRow.put(i, new HashSet<>());
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    int idx = i / 3 * 3 + j / 3;
                    if (board[i][j] != '.') {
                        if(mapCol.get(i).contains(c) || mapRow.get(j).contains(c) || mapArea.get(idx).contains(c)) {
                            return false;
                        } else {
                            mapCol.get(i).add(c);
                            mapRow.get(j).add(c);
                            mapArea.get(idx).add(c);
                        }
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        char[][] test = new char[][] {

        };
    }
}
