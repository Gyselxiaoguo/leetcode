package leetcode_74;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        //二分查找
        int left=0;
        int right=row*col-1;
        while (left<=right){
            int mid=(left+right)/2;
            int m=mid/col;
            int n=mid%col;
            if(matrix[m][n]==target){
                return true;
            }else if(matrix[m][n]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
}
/*public static void main(String[] args) {
        int[] arr={1,3,5,7,9};
        int index = Arrays.binarySearch(arr, 22);
        System.out.println(index);
    }*/