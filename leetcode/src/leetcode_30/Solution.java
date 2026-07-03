package leetcode_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return res;
        }

        Map<String,Integer> wordCount=new HashMap<>();
        int wordTotal = words.length;   //待匹配单词个数
        int wordLen = words[0].length();    //每个待匹配单词长度
        for (String word : words) {
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);   //记录每种待匹配单词的个数
        }

        // 遍历所有起始偏移 0 ~ wordLen-1
        /**
         * words = ["ab","cd"]，wordLen=2，分段模式只有两种：
         * offset=0：从 0、2、4、6… 截取两段字符 [0,2),[2,4)...
         * offset=1：从 1、3、5、7… 截取两段字符 [1,3),[3,5)...
         */
        for (int offset = 0; offset < wordLen; offset++) {
            int left=offset;
            int right=offset;
            int valid=0;    //窗口内有效单词数量
            Map<String,Integer> window=new HashMap<>();

            // 右指针不断向右滑动，每次跳一个单词长度
            while (right+wordLen<=s.length()){
                String curWord = s.substring(right, right + wordLen);
                right+=wordLen;

                // 单词不在目标列表，窗口直接作废
                if(!wordCount.containsKey(curWord)){
                    left=right;
                    valid=0;
                    window.clear();
                }else {
                    window.put(curWord,window.getOrDefault(curWord,0)+1);
                    valid++;

                    // 当前单词数量超出需求，收缩左边界
                    while (window.get(curWord) > wordCount.get(curWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1); //窗口种相应种类的单词数-1
                        valid--;
                        left += wordLen;
                    }

                    // 凑齐全部单词，记录起始位置
                    if(valid==wordTotal){
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}