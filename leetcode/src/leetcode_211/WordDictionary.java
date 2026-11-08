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
            int idx=word.charAt(i)-'a';   //0-25对应a-z
            if(cur.next[idx]==null){  //第一次出现，为其创建下一个节点，同时也标志这该节点已被使用
                cur.next[idx]=new TreeNode();
            }
            cur=cur.next[idx];    //cur移动到下一个TreeNode
        }
        cur.isEnd=true; //标记此处为一个终点
    }
    
    public boolean search(String word) {
        return dfs(root,word,0);
    }

    private boolean dfs(TreeNode cur, String s,int start) {
        if(s.length()==start){
            return cur.isEnd;
        }

        char c = s.charAt(start);
        if(c!='.'){
            if(cur.next[c-'a']==null){
                return false;
            }
            return dfs(cur.next[c-'a'],s,start+1);
        }else {
            for (int i = 0; i < 26; i++) {
                if(cur.next[i]==null){
                    continue;
                }
                if(dfs(cur.next[i],s,start+1)){
                    return true;    //选这个字母分支是可行的，整条搜索成功，直接 return true，不用再试别的字母了。
                }
            }
            return false;   // 26个分支全都试完，没有一条能匹配，返回false
        }
    }
}