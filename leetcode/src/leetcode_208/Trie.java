package leetcode_208;

class TreeNode{
    TreeNode[] next;
    boolean isEnd;
    TreeNode(){
        next=new TreeNode[26];
        isEnd=false;
    }
}

class Trie {

    TreeNode root;
    public Trie() {
        root=new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(cur.next[idx]==null){
                cur.next[idx]=new TreeNode();
            }
            cur=cur.next[idx];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        TreeNode cur=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(cur.next[idx]==null){
                return false;
            }
            cur=cur.next[idx];
        }
        return cur.isEnd;
    }
    /* search(String word) 函数实现的另一种方式：递归，与上面的循环非常相似
    public boolean search(String word) {
        return dfs(root,word,0);
    }
    private boolean dfs(TreeNode node,String s,int pos){
        if(pos==s.length()){
            return node.isEnd;
        }
        int idx=s.charAt(pos)-'a';
        if(node.next[idx]==null){
            return false;
        }
        return dfs(node.next[idx],s,pos+1);
    }*/

    public boolean startsWith(String prefix) {
        TreeNode cur=root;
        for(char c:prefix.toCharArray()){
            int idx=c-'a';
            if(cur.next[idx]==null){
                return false;
            }
            cur=cur.next[idx];
        }
        return true;
    }
}

