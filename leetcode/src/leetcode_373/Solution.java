package leetcode_373;

import java.util.*;

class Solution {

public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    List<List<Integer>> res = new ArrayList<>();
    // 边界：任一数组为空直接返回空集合
    if (m == 0 || n == 0) {
        return res;
    }

    // 标记下标(i,j)是否已经加入堆，防止重复入队
    Set<String> visited = new HashSet<>();
    // 最小堆：比较规则为 nums1[a.i]+nums2[a.j] 减去 nums1[b.i]+nums2[b.j]
    PriorityQueue<Cell> heap = new PriorityQueue<>((a, b) ->
            (nums1[a.i] + nums2[a.j]) - (nums1[b.i] + nums2[b.j])
    );
    heap.offer(new Cell(0,0));
    visited.add("0,0");

    //循环k次最小值
    while (k>0&&!heap.isEmpty()){
        Cell top = heap.poll();
        res.add(Arrays.asList(nums1[top.i],nums2[top.j]));  //将当前最小值加入结果

        //下一个候选：（i+1,j)
        Cell nei=new Cell(top.i+1,top.j);
        int ni = top.i + 1;
        int nj = top.j;
        String key = ni + "," + nj;
        if(nei.i<m&&!visited.contains(key)){
            visited.add(key);
            heap.offer(nei);
        }

        //下一个候选：（i,j+1)
        nei=new Cell(top.i,top.j+1);
        ni = top.i ;
        nj = top.j+1;
        key = ni + "," + nj;
        if(nei.j<n&&!visited.contains(key)){
            visited.add(key);
            heap.offer(nei);
        }

        k--;
    }
    return res;
}
// 内部类：存储下标i,j
static class Cell {
    int i, j;
    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}


}


