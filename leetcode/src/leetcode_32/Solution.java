package leetcode_32;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] marks=new boolean[n];
        Stack<Integer> stack=new Stack<>();
        //标记有效括号位置
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()&&s.charAt(i)==')'){
                continue;
            }
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                Integer pos = stack.pop();
                marks[pos]=true;
                marks[i]=true;
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