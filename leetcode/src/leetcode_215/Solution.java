package leetcode_215;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return array[k-1];
    }
}