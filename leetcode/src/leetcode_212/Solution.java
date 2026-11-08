package leetcode_212;


import java.util.ArrayList;
import java.util.List;

/**
 * 将words中的所有字符放到字典树中
 * 在board中使用dfs回溯
 */
class TreeNode{
    boolean isEnd;
    TreeNode[] next;
    public TreeNode(){
        isEnd=false;
        next=new TreeNode[26];
    }
}

class Solution {
    TreeNode root=new TreeNode();
    char[][] board;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};// 四个方向：上下左右
    List<String> list =new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        //words中所有字符建字典树
        creatTree(words);

        // 遍历棋盘上每一个格子，作为dfs搜索的起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i,j,root,new StringBuilder());
            }
        }
        return list;
    }

    private void dfs(char[][] board,int i, int j, TreeNode cur, StringBuilder sb) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#'){
            return;
        }

        char c = board[i][j];
        int idx=c-'a';
        if(cur.next[idx]==null){   //剪枝
            return;
        }

        sb.append(c);
        TreeNode nextNode = cur.next[idx]; // 走到下一层树节点
        // 找到完整单词
        if(nextNode.isEnd){
            list.add(sb.toString());
            nextNode.isEnd=false;   //避免重复收集同一单词,如 eat，eaten
        }

        board[i][j]='#';    //标记字符使用过
        for (int[] dir : dirs) {
            int x=i+dir[0];
            int y=j+dir[1];
            dfs(board,x,y,nextNode,sb);
        }
        board[i][j]=c;  //恢复
        sb.deleteCharAt(sb.length()-1);
    }

    private void creatTree(String[] words) {
        for (int i = 0; i < words.length; i++) {
            TreeNode cur=root;
            for (int j = 0; j < words[i].length(); j++) {
                int idx=words[i].charAt(j) - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new TreeNode();
                }
                cur = cur.next[idx];
            }
            cur.isEnd = true;
        }
    }
}