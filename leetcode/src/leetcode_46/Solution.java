package leetcode_46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> used=new HashSet<>();
        backtracking(nums,used);
        return res;
    }
    private void backtracking(int[] nums,Set<Integer> used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);  //标记使用过
            path.add(nums[i]);
            backtracking(nums,used);
            path.remove(path.size()-1);
            used.remove(nums[i]);   //去除标记
        }
    }
}



