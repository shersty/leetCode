public class T794 {
    /**
     * 用字符串数组作为井字游戏的游戏板board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
     *
     * 该游戏板是一个 3 x 3 数组，由字符" "，"X"和"O"组成。字符" "代表一个空位。
     *
     * 以下是井字游戏的规则：
     *
     * 玩家轮流将字符放入空位（" "）中。
     * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
     * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
     * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
     * 当所有位置非空时，也算为游戏结束。
     * 如果游戏结束，玩家不允许再放置字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static boolean validTicTacToe(String[] board) {
            char[][] boards = new char[3][3];
            int x = 0, o = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = board[i].charAt(j);
                    if (c == 'x') x++;
                    else if (c == 'o') o++;
                    boards[i][j] = c;
                }
            }
            boolean xWin = check(boards, 'x'), oWin = check(boards, 'o');
            if (x < o || x - o > 1) return false;
            else if (xWin && x <= o) return false;
            else if (oWin && o != x) return false;
            else return !xWin || !oWin;
        }

        public static boolean check(char[][] cs, char c) {
            for (int i = 0; i < 3; i++) {
                if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
                if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            }
            if (cs[0][0] == c && cs[1][1] == c && cs[2][2] == c) return true;
            if (cs[0][2] == c && cs[1][1] == c && cs[2][0] == c) return true;
            return false;
        }
    }
}
