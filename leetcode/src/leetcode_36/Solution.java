package leetcode_36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] row=new boolean[m][n];
        boolean[][] col=new boolean[m][n];
        boolean[][] block=new boolean[m][n];    //3x3块展开

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]!='.'){
                    int num=board[i][j]-'1';    //对应列索引
                    int blockIndex=i/3*3+j/3;   //9个3x3的块的索引

                    if(row[i][num]||col[j][num]||block[blockIndex][num]){
                        return false;
                    }else {
                        row[i][num]=true;
                        col[j][num]=true;
                        block[blockIndex][num]=true;
                    }
                }
            }
        }
        return true;
    }
}