package leetcode_207;

import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // map: key=课程节点, value=该节点前驱数量，所有出现过的节点初始0
        Map<Integer, Integer> map = new HashMap<>();
        // 邻接表：记录边 condition -> course，学完condition才能学course
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        // 1.初始化所有出现的节点入度为0，同时构建邻接表、更新入度
        for (int[] edge : prerequisites) {
            int course = edge[0];   //要学习的课程
            int condition = edge[1];    //学习课程的条件
            //节点的默认前驱个数为0
            map.putIfAbsent(course, 0);
            map.putIfAbsent(condition, 0);
            //节点的前驱个数+1
            map.put(course,map.get(course)+1);
            //构建邻接关系
            if(!adj.containsKey(condition)){
                adj.put(condition,new ArrayList<>());
            }
            adj.get(condition).add(course);
        }
        // 2. 收集map中入度为0的节点
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
                count++;
            }
        }
        // 3.BFS拓扑排序核心逻辑
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            // 当前节点没有后继，直接跳过
            if(!adj.containsKey(cur)){
                continue;
            }
            for (Integer nextCourse : adj.get(cur)) {
                // 节点永远存在map，不会null
                map.put(nextCourse, map.get(nextCourse) - 1);
                // 减完入度为0，入队、计数+1、从map移除
                if(map.get(nextCourse)==0){
                    queue.offer(nextCourse);
                    count++;
                }
            }
        }
        //4.处理完全没出现在prerequisites的孤立课程（入度天然0）
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                count++;
            }
        }

        return count==numCourses;
    }
}


