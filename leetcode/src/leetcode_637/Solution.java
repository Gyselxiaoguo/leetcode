package leetcode_637;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> lists=levelTraversal(root);
        List<Double> res=new ArrayList<>();
        for (List<Integer> list : lists) {
            long sum = list.stream().mapToLong(value -> value).sum();   //相加防止移除，使用Long类型
            double avg = (double) sum / list.size();
            res.add(avg);
        }
        return res;
    }

    private List<List<Integer>> levelTraversal(TreeNode root) {
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