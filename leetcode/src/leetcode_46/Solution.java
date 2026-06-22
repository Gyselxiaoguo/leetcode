package leetcode_46;

import java.util.ArrayList;
import java.util.List;


class Solution {
    //存放结果
    List<List<Integer>> result=new ArrayList<>();
    //临时存放每一个结果
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0){return result;}
        backTrack(nums,new boolean[nums.length]);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used){
    if(path.size()== nums.length){
        result.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if(used[i]){continue;} //用过

        used[i]=true;//第一次使用

        path.add(nums[i]);
        backTrack(nums,used);//回溯
        path.remove(path.size()-1); //删除path中最后一个元素，撤销上一步的选择，让程序回到上一层递归的状态，继续尝试其他可能的选择。

        used[i]=false;//去除标记
    }
}

}



