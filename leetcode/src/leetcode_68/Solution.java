package leetcode_68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int curWidth = 0;

        for (int i = 0; i < words.length; i++) {
            // 判断当前单词能否放进本行：单词长度 + 当前单词总长度 + 最少空格数(cur.size()) <= 最大宽度
            if (words[i].length() + curWidth + cur.size() <= maxWidth) {
                curWidth += words[i].length();
                cur.add(words[i]);
            } else {
                // 生成非最后一行文本
                ans.add(fillSpace(cur, maxWidth, false));
                // 重置当前行，放入当前单词
                cur.clear();
                cur.add(words[i]);
                curWidth = words[i].length();
            }
        }
        //循环结束，cur中存放这最后一行的单词
        // 处理最后一行
        ans.add(fillSpace(cur, maxWidth, true));
        return ans;
    }

    private String fillSpace(List<String> curLine, int maxWidth, boolean last) {
        List<String> words = new ArrayList<>(curLine);
        int curWidth = 0;
        int n = words.size();

        // 第一步：除最后一个单词，每个单词末尾先加一个空格
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                words.set(i, words.get(i) + " ");
            }
            curWidth += words.get(i).length();
        }

        if(last||n==1){
            // 最后一行 / 只有一个单词：末尾补齐所有空格
            words.set(n-1, words.get(n-1)+" ".repeat(maxWidth-curWidth));
        }else {
            // 轮流给前面的间隙追加空格，循环填充，直到填满整行
            int idx=0;
            while (curWidth<maxWidth){
                words.set(idx,words.get(idx)+" ");
                curWidth++;
                // 只在前n-1个间隙循环
                idx=(idx+1)%(n-1);
            }
        }

        // 拼接所有单词
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }
}