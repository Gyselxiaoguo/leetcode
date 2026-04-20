package leetcode_22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*括号生成*/
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    /**
     * @param left:左括号的数量
     * @param right：右括号的数量
     * @param curStr
     */
    private void dfs(int left,int right,String curStr){
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }
        if(left>0){
            dfs(left-1,right,curStr+'(');
        }
        if(right>left){
            dfs(left,right-1,curStr+')');
        }
    }
}