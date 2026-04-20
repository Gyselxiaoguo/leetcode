package leetcode_189;


class Solution {
    public void rotate(int[] nums, int k) {
        //处理空数组或长度为0/1的情况，直接返回（无需旋转）
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len=nums.length;
        //对k取模，得到有效旋转次数（核心！）
        k = k % len;
        //k=0时无需旋转，直接返回
        if (k == 0) {
            return;
        }
        //整体反转
        reverse(nums,0,len-1);
        //局部反转
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    //使数组元素逆序
    private void reverse(int[] arr, int begin, int end){
        while(begin<end){
            int temp;
            temp=arr[begin];
            arr[begin]=arr[end];
            arr[end]=temp;
            begin++;
            end--;
        }
    }
}