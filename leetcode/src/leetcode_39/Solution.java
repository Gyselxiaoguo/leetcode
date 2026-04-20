package leetcode_39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[] myCandidates;
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        myCandidates=candidates;
        Arrays.sort(myCandidates);
        backTrack(0,target,new ArrayDeque<Integer>());
        return res;
    }

    private void backTrack(int idx, int target, ArrayDeque<Integer> path) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < myCandidates.length; i++) {
            int can=myCandidates[i];
            if(can>target)return;
            path.add(can);
            backTrack(i,target-can,path);
            path.removeLast();
        }
    }
}