package leetcode_17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] numToStr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.isEmpty())return list;
        DFS(digits,0,"",list);
        return list;
    }

    private void DFS(String digits, int index, String cur, List<String> list) {
        // 递归终止条件：数字遍历完了
        if (index == digits.length()) {
            list.add(cur);
            return;
        }
        int num = digits.charAt(index) - '0';
        String str = numToStr[num];
        //遍历每个字母，往下一层递归
        for (int i = 0; i < str.length(); i++) {
            DFS(digits,index+1,cur+str.charAt(i),list);
        }
    }
}