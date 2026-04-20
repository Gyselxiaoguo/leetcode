package leetcode_11;

import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int len=height.length;
        int left=0;
        int right=len-1;
        int max=0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int volume=h*(right-left);

            max=Math.max(max,volume);
            if(height[left] < height[right])left++;
            else right--;
        }
        return max;
    }
}