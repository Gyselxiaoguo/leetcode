package leetcode_79;

class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    boolean res=false;
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                search(board,i,j,word,0,new boolean[m][n]); // used：记录本次DFS路径中已经访问过的格子，每次起点都新建一个used
            }
        }
        return res;
    }
    private void search(char[][] board,int i,int j,String word,int start,boolean[][] used){
        if(start==word.length()){   // 递归终止：start走到单词末尾，说明全部匹配成功
            res=true;
            return;
        }

        if(i<0||i>=board.length||j<0||j>=board[0].length||used[i][j]||board[i][j]!=word.charAt(start)){
            return;
        }

        used[i][j]=true;    // 选择：标记当前格子已使用
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            search(board,x,y,word,start+1,used);
        }
        used[i][j]=false;   // 回溯：撤销标记，给别的分支使用这个格子

    }
}