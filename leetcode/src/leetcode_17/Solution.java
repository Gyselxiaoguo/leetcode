package leetcode_17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        backtracking(digits,0);
        return res;
    }

    private void backtracking(String digits,int index){
        if(index==digits.length()){ //index>=digital.length(), 递归终止条件：数字遍历完了
            res.add(sb.toString());
            return;
        }

        int num=digits.charAt(index)-'0';
        String s=numString[num];
        for(int i=0;i<s.length();i++){  //遍历每个字母，往下一层递归
            sb.append(s.charAt(i));
            backtracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}