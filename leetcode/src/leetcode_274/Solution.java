package leetcode_274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); //升序排序
        int n = citations.length;
        for (int i = 0; i < n; i++) {   //排序后，i增加，引用的数量反而减少
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return 0;
    }
}
