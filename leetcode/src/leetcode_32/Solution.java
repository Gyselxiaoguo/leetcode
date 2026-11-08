package leetcode_32;

import java.util.Stack;

/**
 * 把有效括号位置进行标记，最后统计下
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] marks=new boolean[n];
        Stack<Integer> stack=new Stack<>();
        //标记有效括号位置
        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c=='('){
                stack.push(i);
            }else {
                if(!stack.isEmpty()){
                    int top=stack.pop();
                    marks[top]=true;
                    marks[i]=true;
                }
            }
        }

        //找出最长有效括号子串
        int curLen=0;
        int maxLen=0;
        for (boolean mark : marks) {
            if(mark){
                curLen++;
                maxLen=Math.max(curLen,maxLen);
            }else {
                curLen=0;
            }
        }
        return maxLen;
    }
}