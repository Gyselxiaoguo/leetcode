package leetcode_20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            } else if(c==')'||c==']'||c=='}'){
                // 栈为空（无左括号匹配），直接返回false
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.peek();//获得栈顶元素
                stack.pop();//推出栈顶元素
                if(!match(left,c))return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean match(Character left,Character right){
        if(left=='('&&right==')')return true;
        else if (left=='['&&right==']')return true;
        else if (left=='{'&&right=='}')return true;
        else return false;
    }
}