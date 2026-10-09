package leetcode_118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> path=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    path.add(1);
                }else{
                    path.add(res.get(res.size()-1).get(j)+res.get(res.size()-1).get(j-1));
                }
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}