package leetcode_130;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        //遍历左右边界
        for (int i = 0; i < rows; i++) {
            dfs(board,i,0); //左边界
            dfs(board,i,cols-1);    //右边界
        }
        //遍历上下边界
        for (int i = 0; i < cols; i++) {
            dfs(board,0,i); //上边界
            dfs(board,rows-1,i);    //先边界
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }

    }
    private void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }

        board[i][j]='-';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}