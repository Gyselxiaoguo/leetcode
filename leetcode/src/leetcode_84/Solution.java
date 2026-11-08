package leetcode_84;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    /**
     * 栈从底到顶，heights递增
     * 压入栈时，确定左侧索引；
     * 弹出栈时，确定右侧索引
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftFirstMin=new int[n];   //记录该位置左侧第一个比它矮的位置索引
        int[] rightFistMin=new int[n];  //记录该位置右侧第一个比它矮的位置索引
        Stack<Integer> stack=new Stack<>();
        Arrays.fill(leftFirstMin,-1);
        Arrays.fill(rightFistMin,n);

        for (int i = 0; i < heights.length; i++) {
            if(i==0){
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                //弹出栈，确定前一个位置的右侧索引
                int top = stack.pop();
                rightFistMin[top]=i;
            }

            //压入栈中，确定左测索引
            if(!stack.isEmpty()){
                leftFirstMin[i]=stack.peek();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(leftFirstMin));
        System.out.println(Arrays.toString(rightFistMin));
        int max=0;  //求最大矩阵公式：（right-left-1)*height;
        for (int i = 0; i < n; i++) {
            int temp=heights[i]*(rightFistMin[i]-leftFirstMin[i]-1);
            System.out.println(temp);
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }
}