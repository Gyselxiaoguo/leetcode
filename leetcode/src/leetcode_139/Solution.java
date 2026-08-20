package leetcode_139;

import java.util.List;

class Solution {
    /***
     * 决策树
     * @param s
     * @param wordDict
     * @return
     */
    private Boolean[] used; //标记从此处是否可继续向后遍历
    public boolean wordBreak(String s, List<String> wordDict) {
        used =new Boolean[s.length()];
        return backtrack(s,wordDict,0);
    }
    // 决策树递归函数
    private boolean backtrack(String s,List<String> wordDict,int start){
        //终止条件
        if(s.length()==start){
            return true;
        }

        // 剪枝：如果这个位置算过了，直接返回结果，不再递归！
        if (used[start] != null) {
            return used[start];
        }

        // 遍历所有单词 → 每一个单词都是一个决策分支
        for (String word : wordDict) {
            int len=word.length();
            int end=start+len;

            // 越界了就跳过
            if(end>s.length()){
                continue;
            }

            // 如果当前子串匹配单词，就递归下一层
            if(s.substring(start,end).equals(word)){
                if(backtrack(s,wordDict,end)){
                    used[start] = true;
                    return true;
                }
            }
        }
        used[start] = false;
        // 所有分支都试过，不行
        return false;
    }
}