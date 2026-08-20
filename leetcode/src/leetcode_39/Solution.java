package leetcode_39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        return res;
    }

    private void backtracking(int[] candidates, int target,int start){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            int num=candidates[i];
            if(num>target){
                return;
            }
            path.add(num);
            backtracking(candidates,target-num,i);  //可重复使用
            path.remove(path.size()-1);
        }

    }
}