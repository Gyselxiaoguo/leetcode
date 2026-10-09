package leetcode_763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int[] num1=new int[s.length()];   //记录每个下标字符最后出现的位置
        for(int i=0;i<s.length();i++){
            num1[i]=s.lastIndexOf(s.charAt(i));
        }
        int start =0;
        int rightBound=0;   //当前片段最远到达的右边界
        for(int i=0;i<num1.length;i++){ //i走到最远边界，可以切一段
            rightBound = Math.max(rightBound, num1[i]);
            if(i==rightBound){
                res.add(i-start+1);
                start=i+1;
            }
        }
        return res;
    }
}