import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T399 {
    /**
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
     * 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     * 示例 1：
     * <p>
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 示例 2：
     * <p>
     * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * 输出：[3.75000,0.40000,5.00000,0.20000]
     * 示例 3：
     * <p>
     * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * 输出：[0.50000,2.00000,-1.00000,-1.00000]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= equations.length <= 20
     * equations[i].length == 2
     * 1 <= Ai.length, Bi.length <= 5
     * values.length == equations.length
     * 0.0 < values[i] <= 20.0
     * 1 <= queries.length <= 20
     * queries[i].length == 2
     * 1 <= Cj.length, Dj.length <= 5
     * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/evaluate-division
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();

        //初始化并查集
        UnionFindSet unionFindSet = new UnionFindSet(2*size);

        HashMap<String, Integer> ids = new HashMap<>(2*size);
        int id = 0;
        for (int i = 0; i < size; i++) {
            String left = equations.get(i).get(0);
            String right = equations.get(i).get(1);
            double value = values[i];

            if (!ids.containsKey(left)) {
                ids.put(left, id);
                id++;
            }

            if (!ids.containsKey(right)) {
                ids.put(right, id);
                id++;
            }

            //判断是否在并查集中？还是直接合并？
            unionFindSet.union(ids.get(left), ids.get(right), value);
        }

        int querySize = queries.size();
        double[] result = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Integer idx = ids.get(x);
            Integer idy = ids.get(y);

            if (idx == null || idy == null) {
                result[i] = -1.0d;
            } else {
                result[i] = unionFindSet.isConnected(idx, idy);
            }
        }
        return result;
    }

    class UnionFindSet {
        int n;
        int[] father;
        double[] weights;

        public UnionFindSet(int n) {
            this.father = new int[n];
            this.weights = new double[n];
            for (int i = 0; i < n; i++) {
                weights[i] = -1.0d;
                father[i] = i;
            }
        }

        //查找 -- 路径压缩
        int find (int x) {

            if(x != father[x]) {
                int origin = father[x];

                father[x] = find(father[x]);

                weights[x] *=  weights[origin];
            }

            return father[x];
        }

        //联合
        void union(int x, int y, double value) {
            int fatherX = find(x);
            int fatherY = find(y);

            if (fatherX == fatherY){
                return;
            }

            father[x] = y;
            weights[x] = weights[y] * value / weights[x];
        }

        double isConnected(int x, int y) {
            int fatherX = find(x);
            int fatherY = find(y);

            if (fatherX == fatherY) {
                return weights[x] / weights[y];
            } else {
                return -1.0d;
            }
        }

    }

    @Test
    public void test() {
    }
}
