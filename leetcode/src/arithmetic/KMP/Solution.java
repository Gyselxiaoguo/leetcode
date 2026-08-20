package arithmetic.KMP;

import java.util.Arrays;

/**
 * 字符串匹配 leetcode28题
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();  //匹配串
        int m = needle.length();    //模板串
        if(m==0){
            return 0;
        }

        int[] next = getNext(needle);
        int i = 0; // 主串指针
        int j = 0; // 模式串指针

        while (i<n){
            if (j == m) break;
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            } else if (j>0) {
                j=next[j-1];
            }else {
                // j=0，首字符就失配，主串指针右移
                i++;
            }
        }
        // 循环结束后判断是否完整匹配
        if (j == m) {
            return i - j;
        }
        return -1;
    }
    // 构建KMP前缀next数组
    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0; // 初始第一个元素固定0
        int prefix = 0; // 对应
        int suffix = 1;         // 后缀指针从1开始

        while (suffix < n) {
            if (s.charAt(prefix) == s.charAt(suffix)) {
                // 字符匹配，前缀长度+1，存入next，i右移
                prefix++;
                next[suffix] = prefix;
                suffix++;
            } else {
                if (prefix == 0) {
                    // 前缀长度为0，无匹配，当前next填0，i右移
                    next[suffix] = 0;
                    suffix++;
                } else {
                    // 回退前缀长度，i不动，继续对比
                    prefix = next[prefix - 1];
                }
            }
        }
        return next;
    }
}