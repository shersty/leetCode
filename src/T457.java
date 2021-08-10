import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T457 {

    class Solution {
        // 邻接表存储的图
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        // 入度数组
        int[] Indeg = new int[5005];

        // 拓扑排序
        boolean toposort(int n) {
            Queue<Integer> q = new LinkedList<Integer>();

            // 首先将入度为 0 的点存入队列
            for(int i = 0; i < n; i++) {
                if(Indeg[i] == 0) {
                    q.offer(i);
                }
            }

            while(!q.isEmpty()) {
                // 每次弹出队头元素
                int cur = q.poll();
                for(int x : graph.get(cur)) {
                    // 将以其为起点的有向边删除，更新终点入度
                    Indeg[x]--;
                    if(Indeg[x] == 0) q.offer(x);
                }
            }

            // 仍有入度不为 0 的点，说明图中有环
            for(int i = 0; i < n; i++) {
                if(Indeg[i] != 0) return true;
            }
            return false;
        }

        public boolean circularArrayLoop(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<Integer>());
            }

            // 先处理正向边 nums[i] > 0 的情况
            for(int i = 0; i < n; i++) {
                int end = ((i + nums[i]) % n + n) % n;
                if(nums[i] <= 0 || i == end) continue;
                graph.get(i).add(end);
                Indeg[end]++;
            }


            if(toposort(n)) return true;

            graph.clear();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < n; i++) Indeg[i] = 0;

            // 再处理负向边 nums[i] < 0 的情况
            for(int i = 0; i < n; i++) {
                int end = ((i + nums[i]) % n + n) % n;
                if(nums[i] >= 0 || i == end) continue;
                graph.get(i).add(end);
                Indeg[end]++;
            }

            if(toposort(n)) return true;

            return false;
        }
    }
}
