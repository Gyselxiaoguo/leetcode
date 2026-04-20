package leetcode_394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {

        StringBuilder currentStr=new StringBuilder();//向栈中放字符串
        Stack<Integer> numStack=new Stack<>();//数字栈
        Stack<String> strStack=new Stack<>();//字符串栈
        int currentNum=0;

        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                //记录数字
                currentNum=currentNum*10+(c-'0');
            } else if (c == '[') {
                // 遇到左括号，将当前数字和字符串压栈，然后重置
                numStack.push(currentNum);
                strStack.push(currentStr.toString());
                currentNum=0;
                currentStr.setLength(0);//清空当前字符串
            } else if (c == ']') {
                // 遇到右括号，弹出栈顶的数字和字符串，进行拼接
                int repeatTimes = numStack.pop();
                String prefix = strStack.pop();
                StringBuilder temp=new StringBuilder(prefix);
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentStr);
                }
                currentStr=temp;
            }else {
                //字符，直接追加
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }
}