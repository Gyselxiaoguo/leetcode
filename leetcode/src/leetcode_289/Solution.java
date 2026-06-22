package leetcode_289;

class Solution {
    int[][] dirs = {
            {-1, 0},  // 正上
            {-1, 1},  // 右上
            {0, 1},   // 正右
            {1, 1},   // 右下
            {1, 0},   // 正下
            {1, -1},  // 左下
            {0, -1},  // 正左
            {-1, -1}  // 左上
    };
    public void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        int[][] newBoard=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int flag = arbitration(i,j,board[i][j],board);
                newBoard[i][j]=flag;
            }
        }
        // 逐行拷贝覆盖原数组，不能直接board = newBoard
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, cols);
        }
    }

    //判断下一个状态
    private int arbitration(int x,int y,int cur, int[][] board) {
        //当前位置周围1的数量
        int count=0;
        for (int[] dir : dirs) {
            int m = dir[0] + x;
            int n = dir[1] + y;
            if (m < 0 || m >= board.length || n < 0 || n >= board[0].length) {
                continue;
            }
            if (board[m][n] == 1) {
                count++;
            }
        }

        if(cur==1&&(count<2||count>3)){ //活细胞死亡
            return 0;
        }else if(cur==1){ //活细胞仍然存活
            return 1;
        }else if(cur==0&&count==3){ //死细胞复活
            return 1;
        }
        return 0;
    }

}