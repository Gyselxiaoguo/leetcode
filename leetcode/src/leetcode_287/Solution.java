package leetcode_287;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> list=new HashSet<>();
        for (int num : nums) {
            if(!list.add(num)){
                return num;
            }else{
                list.add(num);
            }
        }
        return -1;
    }
}