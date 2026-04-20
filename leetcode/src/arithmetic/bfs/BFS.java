package arithmetic.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
    //广度优先遍历解决层序遍历问题
    private List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null)queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //取出队头节点
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}

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