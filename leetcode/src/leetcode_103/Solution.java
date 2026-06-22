package leetcode_103;


import java.util.*;
import java.util.stream.IntStream;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=levelTraversal(root);
        IntStream.range(0,lists.size())
                .filter(i->(i+1)%2==0)  //过滤，只剩下要翻转的位置
                .forEach(i->{   //翻转
                    List<Integer> list = lists.get(i);
                    Collections.reverse(list);
                });

        return lists;
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