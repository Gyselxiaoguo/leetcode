package leetcode_150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        //不涉及运算情况
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        //涉及运算情况
        Stack<Integer> stack=new Stack<>();
        for (String token : tokens) {
            if("+".equals(token)){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 + num1);
            }else if("-".equals(token)){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 - num1);
            }else if("*".equals(token)){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 * num1);
            }else if("/".equals(token)){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 / num1);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}