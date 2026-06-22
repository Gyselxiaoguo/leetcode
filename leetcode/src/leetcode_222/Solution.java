package leetcode_222;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        List<List<Integer>> list= levelOrder(root);
        //前n-1层套用公式2^(n-1)-1计算节点个数,第n层遍历计数
        int layers = list.size();
        if (layers == 0) return 0;
//        return  (int) (Math.pow(2, layers - 1) - 1)+list.get(layers-1).size();
        return (1 << (layers - 1)) - 1 + list.get(layers-1).size();
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}