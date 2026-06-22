package leetcode_208;

class Trie {

    class TreeNode{
        boolean isEnd;
        TreeNode[] next;
        public TreeNode(){
            isEnd=false;
            next=new TreeNode[26];
        }
    }

    TreeNode root;
    public Trie() {
        root=new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur=root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if(cur.next[c-'a']==null){
                cur.next[c-'a']=new TreeNode();
            }
            cur=cur.next[c-'a'];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(root,word);
    }

    private boolean dfs(TreeNode node, String s) {
        if(s.length()==0){
            return node.isEnd;
        }

        char c = s.charAt(0);
        if(node.next[c-'a']!=null&&dfs(node.next[c-'a'],s.substring(1))){
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if(cur.next[c-'a']==null){
                return false;
            }
            cur=cur.next[c-'a'];
        }
        return true;
    }
}