package leetcode_22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTracking(n,n,sb);
        return res;
    }
    /**
     left：剩余还可以用的左括号数量，初始n个
     right：剩余还可以用的右括号数量，初始n个
     */
    private void backTracking(int left,int right,StringBuilder sb){
        if(left==0&&right==0){
            res.add(sb.toString());
            return;
        }
        // left>0：还有剩下的左括号就可以选左括号
        if(left>0){
            sb.append('(');
            backTracking(left-1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        // left < right：剩余左括号 < 剩余右括号
        // 等价于：已经用掉的左括号 > 已经用掉的右括号
        // 此时才能放右括号，否则会出现非法括号如 ())
        if(left<right){
            sb.append(')');
            backTracking(left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}