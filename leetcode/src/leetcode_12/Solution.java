package leetcode_12;

class Solution {
    private final String[] sigals={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  //13个
    private final int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    StringBuilder res=new StringBuilder();
    public String intToRoman(int num) {
        int idx=0;
        while(num>0){
            if(num-nums[idx]>=0){
                num-=nums[idx];
                res.append(sigals[idx]);
            }else{
                idx++;
            }

        }
        return res.toString();
    }
}