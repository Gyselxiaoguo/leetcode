package leetcode_739;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*方法1*/
/*
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        List<Integer> list=new ArrayList<>(len);
        //遍历数组
        for (int i = 0; i < len; i++) {
            //从当前位置向后找
            int count=0;
            for (int j = i+1; j < len; j++) {
                if(temperatures[i]<temperatures[j]){
                    //找到第一个高温,存入距离
                    count=j-i;
                    break;
                }
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}*/

/*方法2*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();//存下标

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int preIndex=stack.pop();
                res[preIndex] = i-preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
