package leetcode_373;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        //数组a中存放了num1和num2的索引。这是个小根堆
        PriorityQueue<int[]> deap=new PriorityQueue<>((a,b)->
                (nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        //num1中的每个元素均与num2中的第一个元素的索引结合
        for(int i=0;i<nums1.length;i++){
            deap.add(new int[]{i,0});
        }

        while(k>0&&!deap.isEmpty()){
            int[] pos=deap.poll();
            int i=pos[0];
            int j=pos[1];
            res.add(List.of(nums1[i],nums2[j]));
            if(j+1<nums2.length){
                deap.add(new int[]{i,j+1});
            }
            k--;
        }
        return res;
    }
}