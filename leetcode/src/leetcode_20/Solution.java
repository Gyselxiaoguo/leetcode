package leetcode_20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int i=0;
        Stack<Character> stack=new Stack<>();
        while(i<n){
            char c=arr[i];
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    char top=stack.peek();
                    if((c==')'&&top=='(')||(c==']'&&top=='[')||(c=='}'&&top=='{')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}