package leetcode_287;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if(set.add(num)){
                continue;
            }else{
                return num;
            }
        }
        return -1;
    }
}