import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    /**
     *  在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，
     *  所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     *
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
     * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
     * 可以射出的弓箭的数量没有限制。
     * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     *
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     *
     *  
     * 示例 1：
     *
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
     * 示例 2：
     *
     * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
     * 输出：4
     * 示例 3：
     *
     * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
     * 输出：2
     * 示例 4：
     *
     * 输入：points = [[1,2]]
     * 输出：1
     * 示例 5：
     *
     * 输入：points = [[2,3],[2,3]]
     * 输出：1
     *  
     *
     * 提示：
     *
     * 0 <= points.length <= 104
     * points[i].length == 2
     * -2^31 <= xstart < xend <= 23^1 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {

        public static int findMinArrowShots(int[][] points) {
            if (points.length <= 1)
                return points.length;

            // 按照开始坐标排序
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

            int right = points[0][1];
            int num = 1;

            for (int i = 1; i < points.length; i++) {
                // 当当前气球左端点大于记录的右端点时，需要更换一个箭，同时右端点更新为当前气球右端点
                if (points[i][0] > right) {
                    num++;
                    right = points[i][1];
                    System.out.println("need another " + i);
                } else {
                    //当当前气球右端点小于记录的右端点时，更新右端点为当前气球右端点
                    if (points[i][1] < right) {
                        right = points[i][1];
                    }
                    System.out.println("no need another " + i);
                }
            }
            return num;
        }

        public static int findMinArrowShots2(int[][] points) {
            if (points.length <= 1)
                return points.length;
            // 按照右坐标排序
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

            int num = 1;
            int right = points[0][1];
            for (int[] point: points) {
                if (point[0] > right) {
                    num++;
                    right = point[1];
                }
            }
            return num;
        }

        public static void main(String[] args) {
            // [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
            int[][] test = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
            int[][] test1 = new int[][]{{1, 2}};
            int[][] test2 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
            int[][] test3 = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
            int num = findMinArrowShots2(test3);
            System.out.println(num);
        }
    }
}
