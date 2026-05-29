package leetcode_763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        //1.遍历，找到与当前字符一样的最后一个字符的索引---数组1
        int[] nums1=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums1[i]=i;
            for (int j = i+1; j < s.length(); j++) {
                char temp=s.charAt(i);
                if(temp==s.charAt(j)){
                    nums1[i]=j;
                }
            }
        }
        //2.遍历num1，将每个值设为截至到当前最大的索引值---数组2   索引与数组2数值相同处就是片段分割点
        int[] nums2=new int[s.length()];
        nums2[0]=nums1[0];
        int start=0;
        for (int i = 0; i < nums1.length; i++) {
            if(i>0)nums2[i]=Math.max(nums2[i-1],nums1[i]);
            if(i==nums2[i]){
                ans.add(i-start+1);
                start=i+1;
            }
        }
       return ans;
    }
}