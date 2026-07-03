package leetcode_135;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        for (int i = 1; i < n; i++) {   //记录当前位置左侧单调递增元素个数
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){   //记录当前位置右侧单调递减元素个数
            if (ratings[i] > ratings[i+1]) {
                right[i]=right[i+1]+1;
            }
        }
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=Math.max(left[i],right[i])+1;    //每人至少1个糖果
        }
        return Arrays.stream(res).sum();
    }
}