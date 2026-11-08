package leetcode_155;

import java.util.Stack;

//两个栈就行
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            minStack.push(Math.min(val,minStack.peek()));
        }else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}