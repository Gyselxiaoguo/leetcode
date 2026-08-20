package leetcode_135;


class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){   //记录当前位置左侧单调递增元素个数
            if(i==0){
                continue;
            }
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--){    //记录当前位置右侧单调递减元素个数
            if(i==n-1){
                continue;
            }
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.max(left[i],right[i])+1;  //每人至少1个糖果
        }
        return sum;
    }
}