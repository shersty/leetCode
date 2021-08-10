import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class T847 {

    class Solution {

        /**
         * 带状态压缩的BFS
         * @param graph 图
         * @return 访问所有节点的最短路径
         */
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;

            // 1.初始化队列及标记数组，存入起点
            Queue<int[]> queue = new LinkedList<int[]>(); // 三个属性分别为 idx, mask, dist
            boolean[][] vis = new boolean[n][1 << n]; // 节点编号及当前状态
            for (int i = 0; i < n; i++) {
                queue.offer(new int[]{i, 1 << i, 0}); // 存入起点，起始距离0，标记
                vis[i][1 << i] = true;
            }

            // 开始搜索
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll(); // 弹出队头元素
                int idx = tuple[0], mask = tuple[1], dist = tuple[2];

                // 找到答案，返回结果
                // 当mask为 2^n - 1 时，所有位都是1，表示所有点都遍历到了
                if (mask == (1 << n) - 1) return dist;

                // 扩展
                for (int x : graph[idx]) {
                    int next_mask = mask | (1 << x);
                    if (!vis[x][next_mask]) {
                        queue.offer(new int[]{x, next_mask, dist + 1});
                        vis[x][next_mask] = true;
                    }
                }
            }
            return 0;
        }
    }

    @Test
    public void test() {
        for (int i = 0; i < 6; i++) {
            System.out.println(1 << i);
        }
    }
}
