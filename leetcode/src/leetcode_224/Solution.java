package leetcode_224;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        //1.去空格
        String newS = s.replace(" ", "");

        //2.操作数栈 运算符栈
        Stack<Character> opStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        int i=0;
        int n = newS.length();

        while (i< n){
            char c = newS.charAt(i);
            // 处理一元负号：开头- 或 (后-
            if(c=='-'&&(i==0||newS.charAt(i-1)=='(')){
                // 判断负号后是左括号 -(...)
                if (i + 1 < n && newS.charAt(i+1) == '(') {
                    // 等价于 0 - ( ... )
                    numStack.push(0);
                    opStack.push('-');
                    i++; // 跳过'-'，下一轮处理'('
                    continue;
                }else {
                    // 负号后是数字
                    i++;
                    int num=0;
                    while (i<n&&Character.isDigit(newS.charAt(i))){
                        num=num*10+(newS.charAt(i)-'0');
                        i++;
                    }
                    numStack.push(-num);
                    continue;
                }
            }
            if(Character.isDigit(c)){   //数字
                int num=0;
                while (i<n&&Character.isDigit(newS.charAt(i))){
                    num=num*10+(newS.charAt(i)-'0');
                    i++;
                }
                numStack.push(num);
            } else if (c=='(') {    //遇到‘（’
                opStack.push(c);
                i++;
            } else if (c==')') {    //遇到‘）’,计算到左括号为止
                while (opStack.peek()!='('){
                    calc(numStack,opStack);
                }
                opStack.pop();  //弹出‘（’
                i++;
            }else if(c == '+' || c == '-') {   //运算符
                while (!opStack.isEmpty()&&opStack.peek()!='('){
                    calc(numStack,opStack);
                }
                opStack.push(c);
                i++;
            }
        }
        // 遍历完，处理栈中剩余运算符
        while (!opStack.isEmpty()){
            calc(numStack,opStack);
        }
        return numStack.pop();
    }

    //取出两个数字和一个运算符进行计算，结果压回数字栈
    private void calc(Stack<Integer> numStack, Stack<Character> opStack) {
        Integer b = numStack.pop();
        Integer a = numStack.pop();
        Character op = opStack.pop();
        if(op=='+'){
            numStack.push(a+b);
        }else if(op=='-'){
            numStack.push(a-b);
        }
    }
}