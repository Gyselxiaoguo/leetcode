package leetcode_131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res=new ArrayList<>();
    List<String> path=new ArrayList<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("aaa"));
    }
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }
    private void backtrack(String s ,int start){
        //结束条件
        if(start==s.length()){
            //切完了
            res.add(new ArrayList<>(path));
            return;
        }
        //决策：尝试切 1,2,... 长度的子串
        for(int i=start;i<s.length();i++){
            //切取子串
            String sub = s.substring(start, i + 1);
            //1.剪枝
            if(!isPalindrome(sub)){
                continue;
            }
            //2.做选择
            path.add(sub);
            //3.递归
            backtrack(s,i+1);
            //4.回溯
            path.remove(path.size()-1);
        }
    }
    private boolean isPalindrome(String s){
        String newStr = new StringBuffer(s).reverse().toString();
        return newStr.equals(s);
    }
}