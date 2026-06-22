package leetcode_399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * 核心思想：带权并查集
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind (2 * equationsSize);
        //第1步:预处理，将变量的值与id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>( 2 * equationsSize);
        int id = 0;
        for(int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if(!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }

            unionFind.union(hashMap.get(var1),hashMap.get(var2), values[i]);
        }

        //第2步:做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if (id1 == null || id2 == null){
                res[i] = -1.0;
            }else{
                res[i] = unionFind.isConnected(id1, id2);
            }
        }

        return res;
    }
    class UnionFind{
        int[] parent;
        /**
         * 节点指向父节点的权值
         */
        double[] weight;

        //初始化：每个节点自己是自己的父
        public UnionFind(int n){
            this.parent=new int[n];
            this.weight=new double[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
                weight[i]=1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }
        /**
         路径压缩 + 更新权重
         **/
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);    // 递归找到根，路径压缩，x直接指向根
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x,int y){
            int rootX=find(x);
            int rootY = find(y);
            if(rootX==rootY){
                return weight[x]/weight[y];
            }else {
                return -1.0d;
            }
        }

    }
}
