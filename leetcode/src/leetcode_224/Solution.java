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

        // 预防表达式开头的正负号，如 "-2+1" -> 补 0 变成 "0-2+1"
        if (n > 0 && (newS.charAt(0) == '-' || newS.charAt(0) == '+')) {
            numStack.push(0);
        }
        while (i< n){
            char c = newS.charAt(i);

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
                // 如果括号后紧跟 '+' 或 '-'，如 "(-3)"，补一个 0 变成 "(0-3)"
                if (i < n && (newS.charAt(i) == '+' || newS.charAt(i) == '-')) {
                    numStack.push(0);
                }
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