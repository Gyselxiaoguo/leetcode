package leetcode_909;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * 暴力解法，广度优先遍历
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;   //行数
        int target = n * n; // 终点编号
        // visited[i] 标记编号i是否访问过
        boolean[] visited = new boolean[target + 1];
        // 队列存储 [当前格子编号, 当前步数]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curNum = curr[0];   //格子编号
            int step = curr[1];     //到达此格子所需步数

            // 骰子1~6点
            for (int dice = 1; dice <= 6; dice++) {
                int nextNum = curNum + dice;    //格子编号（1-n^2)
                if (nextNum > target) continue; // 超出棋盘跳过

                // 将格子编号转换为二维数组坐标
                int[] pos = numToRowCol(nextNum, n);
                int row = pos[0];   //二维数组-横坐标
                int col = pos[1];   //二维数组-纵坐标

                // 有梯子/蛇则跳转
                if (board[row][col] != -1) {
                    nextNum = board[row][col];
                }

                // 到达终点，返回当前步数+1（本次掷骰子）
                if (nextNum == target) {
                    return step + 1;
                }

                // 未访问过则入队
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.offer(new int[]{nextNum, step + 1});
                }
            }
        }
        // 无法到达终点
        return -1;
    }

/**
        * 格子编号num 转换为 board 的[row, col]坐标
 *
         * @param num 1~n²
            * @param n   棋盘边长
 * @return [行, 列]*/


    private int[] numToRowCol(int num, int n) {
        // 从0开始的偏移
        int idx = num - 1;
        // 从底部往上数的行号（0开始）
        int bottomRow = idx / n;
        // 原始列
        int col = idx % n;
        // 真实数组行：底部行反向映射到board数组顶部
        int row = n - 1 - bottomRow;

        // 奇数bottomRow：该行左右反转
        if (bottomRow % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}



