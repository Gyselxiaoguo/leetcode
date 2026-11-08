package leetcode_394;

import java.util.Stack;

class Solution {

    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();// 数字栈
        Stack<String> strStack=new Stack<>();//字符串栈
        StringBuilder curStr=new StringBuilder();//保存当前正在拼接的字符串

        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int num=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                numStack.push(num);
            }else if(c=='['){   // 遇到左括号：把当前已经拼好的字符串存到栈里
                strStack.push(curStr.toString());
                curStr.setLength(0);
                i++;
            }else if(c==']'){   // 遇到右括号：开始解码，取出倍数和之前保存的前缀
                int time = numStack.pop();
                String preStr = strStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < time; k++) {
                    temp.append(curStr);
                }
                curStr = new StringBuilder(preStr + temp);

                i++;
            }else{
                curStr.append(c);   // 普通字母，直接追加到当前字符串
                i++;
            }
        }
        return curStr.toString();
    }
}