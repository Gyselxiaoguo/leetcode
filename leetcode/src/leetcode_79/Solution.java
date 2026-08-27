package leetcode_79;

class Solution {
    char[][] myBoard;
    char[] myWord;
    boolean res;
    int[][] move={{1,0},{0,-1},{-1,0},{0,1}};

    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        myBoard=board;
        myWord=word.toCharArray();
        boolean[][] visited=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backtrack(i,j,0,visited);
            }
        }
        return res;
    }
    private void backtrack(int row,int col ,int index,boolean[][] visited){
        if(row<0||row>=myBoard.length||col<0||col>=myBoard[0].length
                ||visited[row][col]||myBoard[row][col]!=myWord[index]){
            return;
        }
        if(index==myWord.length-1){
            res=true;
            return;
        }
        visited[row][col]=true;
        for (int i = 0; i < move.length; i++) {
            row+=move[i][0];
            col+=move[i][1];
            backtrack(row, col, index+1, visited);
            row-=move[i][0];
            col-=move[i][1];
        }
        visited[row][col]=false;
    }
}