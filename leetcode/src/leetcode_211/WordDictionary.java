package leetcode_211;

class WordDictionary {
    /**
     * 字典树
     */
    class TreeNode {
        boolean isEnd;
        TreeNode[] next;
        public TreeNode(){
            isEnd=false;
            next=new TreeNode[26];
        }
    }

    TreeNode root;
    public WordDictionary() {
        root=new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode cur=root;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';   //0-25对应a-z
            if(cur.next[index]==null){  //第一次出现，为其创建下一个节点，同时也标志这该节点已被使用
                cur.next[index]=new TreeNode();
            }
            cur=cur.next[index];    //cur移动到下一个TreeNode
        }
        cur.isEnd=true; //标记此处为一个终点
    }
    
    public boolean search(String word) {
        return dfs(root,word);
    }

    private boolean dfs(TreeNode node, String s) {
        if(s.length()==0){
            return node.isEnd;
        }

        char c = s.charAt(0);
        if(c!='.'){
            if(node.next[c-'a']!=null&&dfs(node.next[c-'a'],s.substring(1))){
                return true;
            }
        }else {
            for (int i = 0; i < 26; i++) {
                if(node.next[i]!=null&&dfs(node.next[i],s.substring(1))){
                    return true;
                }
            }
        }

        return false;
    }
}