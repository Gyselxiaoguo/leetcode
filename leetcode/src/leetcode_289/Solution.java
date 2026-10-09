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
                newBoard[i][j]=backtracking(board,i,j);
            }
        }
        // 逐行拷贝覆盖原数组，不能直接board = newBoard
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, cols);
        }
    }

    //判断下一个状态
    private int backtracking(int[][] board,int i,int j){
        int live=0;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0||y<0||x>=board.length||y>=board[0].length){
                continue;
            }
            if(board[x][y]==1){
                live++;
            }
        }
        if(board[i][j]==1){
            return live<2||live>3?0:1;
        }else{
            return live==3?1:0;
        }
    }
}