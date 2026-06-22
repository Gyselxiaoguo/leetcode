package leetcode_77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 保存所有组合结果
    List<List<Integer>> result = new ArrayList<>();
    // 单次递归路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    // 回溯函数
    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}