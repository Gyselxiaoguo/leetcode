package leetcode_78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums,int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex>=nums.length){
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}