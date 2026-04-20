package leetcode_238;

class Solution {
    /***
     * 方法一：所有元素相乘得到s,遍历，除
     * 方法二：遍历，元素前的乘积x元素后的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] pre=new int[len];
        int[] suf=new int[len];
        pre[0]=1;
        suf[len-1]=1;
        //前缀数组
        for (int i = 1; i < len; i++) {
            pre[i]=pre[i-1]*nums[i-1];
        }
        //后缀数组
        for (int i = len-2; i >=0; i--) {
            suf[i]=suf[i+1]*nums[i+1];
        }
        //pre*suf
        for (int i = 0; i < len; i++) {
            nums[i]=pre[i]*suf[i];
        }
        return nums;
    }
}