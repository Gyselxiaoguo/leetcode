package leetcode_84;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    /**
     * 压入栈时，确定左侧索引；弹出栈时，确定右侧索引
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftMin=new int[n];   //记录该位置左侧第一个比它矮的位置索引
        int[] rightMin=new int[n];  //记录该位置右侧第一个比它矮的位置索引
        Stack<int[]> stack=new Stack<>();
        Arrays.fill(leftMin,-1);
        Arrays.fill(rightMin,n);

        for (int i = 0; i < heights.length; i++) {
            if(i==0){
                stack.push(new int[]{heights[i],i});
                continue;
            }

            while (!stack.isEmpty()&&heights[i]<stack.peek()[0]){
                //弹出栈，确定前一个位置的右侧索引
                int[] top = stack.pop();
                rightMin[top[1]]=i;
            }

            //压入栈中，确定左测索引
            if(!stack.isEmpty()){
                leftMin[i]=stack.peek()[1];
            }
            stack.push(new int[]{heights[i],i});
        }
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));
        int max=0;  //求最大矩阵公式：（right-left-1)*height;
        for (int i = 0; i < n; i++) {
            int temp=heights[i]*(rightMin[i]-leftMin[i]-1);
            System.out.println(temp);
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }
}