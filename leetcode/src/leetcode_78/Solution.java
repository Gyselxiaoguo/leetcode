package leetcode_78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    int[] _nums;
    public List<List<Integer>> subsets(int[] nums) {
        _nums=nums;
        backTrack(0);
        return res;
    }
    private void backTrack(int idx){
        res.add(new ArrayList<>(path));
        for (int i = idx; i < _nums.length; i++) {
            path.add(_nums[i]);
            backTrack(i+1);
            path.remove(path.size()-1);
        }
    }
}