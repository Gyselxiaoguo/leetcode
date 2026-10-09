package leetcode_274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Integer[] arr=Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(a,b)->b.compareTo(a));//降序

        int res=0;
        for(int i=0;i<arr.length;i++){
            if(i+1<=arr[i]){
                res=i+1;
                continue;
            }
            break;
        }
        return res;
    }
}