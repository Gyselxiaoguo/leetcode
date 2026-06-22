package leetcode_210;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer, List<Integer>> confineMap=new HashMap<>();
        Queue<Integer> queue=new ArrayDeque<>();
        List<Integer> order=new ArrayList<>();

        //1.初始化
        for (int[] set : prerequisites) {
            int course = set[0];
            int condition = set[1];
            map.putIfAbsent(course,0);
            map.putIfAbsent(condition,0);
            map.put(course,map.get(course)+1);
            confineMap.computeIfAbsent(condition,k->new ArrayList<>()).add(course);
        }
        //2.将入度为0的节点放入队列
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==0){
                queue.offer(entry.getKey());
                order.add(entry.getKey());
                count++;
            }
        }
        //3.dfs
        while (!queue.isEmpty()){
            Integer key = queue.poll();
            if(!confineMap.containsKey(key)){
                continue;
            }
            for (Integer node : confineMap.get(key)) {
                int rest = map.get(node) - 1;
                map.put(node,rest);
                if(rest==0){
                    queue.offer(node);
                    order.add(node);
                    count++;
                }
            }
        }
        //4.处理游离节点
        for (int i = 0; i < numCourses; i++) {
            if(!map.containsKey(i)){
                count++;
                order.add(i);
            }
        }
        return count==numCourses?order.stream().mapToInt(Integer::intValue).toArray():new int[0];
    }
}