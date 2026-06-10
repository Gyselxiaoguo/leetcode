package leetcode_12;

class Solution {
    private final int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private final String[] romanStr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int index=0;
        while (num>0){
            if(num-nums[index]>=0){
                num-=nums[index];
                sb.append(romanStr[index]);
            }else {
                index++;
            }
        }
        return sb.toString();
    }
}
