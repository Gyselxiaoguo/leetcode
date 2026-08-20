package leetcode_239;

import java.util.*;

class Solution {
    /**
     * 双端队列Deque存滑动窗口中降序排序的元素
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        Deque<Integer> deque=new ArrayDeque<>();   //滑动窗口中存储数组元素的索引

        for (int right = 0; right < n; right++) {
            // 1. 维护单调递减：队尾小于当前值全部弹出
            while (!deque.isEmpty()&&nums[right]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(right);

            // 2. 移除滑出窗口的过期下标
            int left = right - k + 1;
            while (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // 3. 窗口长度达到k，开始记录答案
            if (right >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}