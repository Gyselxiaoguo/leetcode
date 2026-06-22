package leetcode_42;


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax=new int[n];   //当前柱子极其左边的最大值
        int[] rightMax=new int[n];   //当前柱子极其右边的最大值

        //记录当前柱左侧最大值（包括自身）
        leftMax[0]=height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i]= Math.max(height[i],leftMax[i-1]);
        }

        //记录当前柱右侧最大值（包括自身）
        rightMax[n-1]=height[n-1];
        for(int j=n-2;j>=0;j--){
            rightMax[j]=Math.max(height[j],rightMax[j+1]);
        }

        int sum=0;  //总的储水量
        //当前位置储水量=min(左侧最高柱，右侧最高柱)-当前柱高
        for (int i = 0; i < n; i++) {
            sum+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return sum;
    }
}
