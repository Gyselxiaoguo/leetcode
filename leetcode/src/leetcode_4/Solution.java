package leetcode_4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证nums1是短数组，减少二分次数
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m - 1; // 修改为 m-1
        int totalLeft = (m + n + 1) / 2;    //左边元素个数，始终比右边多一个/相等

        while (left <= right) {
            int mid =(right + left) / 2; // 新增mid，常规二分写法
            // mid是下标，i代表左侧元素数量 = mid + 1
            int i = mid + 1;
            int j = totalLeft - i;

            // nums1左段最后一个元素大于nums2右段第一个，需要左移
            if (nums1[i - 1] > nums2[j]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 最终分割位置i就等于left
        int i = left;
        int j = totalLeft - i;

        // 边界处理，空一侧赋值无穷值
        int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];  //num1中，被划到左侧的左边界
        int right1 = i == m ? Integer.MAX_VALUE : nums1[i]; //num1中，被划到右侧的右边界
        int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];  //num2中，被划到左侧的左边界
        int right2 = j == n ? Integer.MAX_VALUE : nums2[j]; //num2中，被划到右侧的右边界

        // 奇数取左半边最大值；偶数取左最大与右最小的平均值
        if ((m + n) % 2 == 1) {
            return Math.max(left1, left2);
        } else {
            return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
        }
    }
}