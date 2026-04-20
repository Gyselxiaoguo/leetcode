package leetcode_208;

class TreeNode{
    boolean isEnd;
    TreeNode[] next;
    public TreeNode(){
        this.isEnd=false;
        this.next=new TreeNode[26];
    }
}
class Trie {

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode curr=root;
        int len=word.length();
        for (int i = 0; i < len; i++) {
            int ch=word.charAt(i)-'a';
            if(curr.next[ch]==null){
                //没有元素，添加
                curr.next[ch]=new TreeNode();
            }
            curr=curr.next[ch];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TreeNode curr=root;
        int len=word.length();
        for (int i = 0; i < len; i++) {
            int ch=word.charAt(i)-'a';
            if(curr.next[ch]==null){
                return false;
            }
            curr=curr.next[ch];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode curr=root;
        int len=prefix.length();
        for (int i = 0; i < len; i++) {
            int ch = prefix.charAt(i) - 'a';
            if(curr.next[ch]==null){
                return false;
            }
            curr=curr.next[ch];
        }
        return true;
    }
}