package leetcode_20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for(char c:s.toCharArray()){
            if(stack.isEmpty()||c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }
            if(!stack.isEmpty()){
                if(c==')'&&stack.peek()=='('){
                    stack.pop();
                }else if(c==']'&&stack.peek()=='['){
                    stack.pop();
                }else if(c=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}