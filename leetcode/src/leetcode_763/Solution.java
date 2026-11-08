package leetcode_763;

import java.util.ArrayList;
import java.util.List;

/**
 * 找元素最后一次出现的位置，然后试图扩大范围
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[s.length()];   //记录每个下标字符最后出现的位置
        for(int i=0;i<s.length();i++){
            arr[i]=s.lastIndexOf(s.charAt(i));
        }
        int start =0;
        int end=0;   //当前片段最远到达的右边界
        for(int i=0;i<arr.length;i++){ //i走到最远边界，可以切一段
            end = Math.max(end, arr[i]);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}