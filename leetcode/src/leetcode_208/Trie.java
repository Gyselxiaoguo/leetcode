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

