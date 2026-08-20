package leetcode_150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")){
                calc(stack,s);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
    private void calc(Stack<Integer> stack,String s){
        int num1=stack.pop();
        int num2=stack.pop();
        if(s.equals("+")){
            stack.push(num2+num1);
        }else if(s.equals("-")){
            stack.push(num2-num1);
        }else if(s.equals("/")){
            stack.push(num2/num1);
        }else if(s.equals("*")){
            stack.push(num2*num1);
        }
    }
}