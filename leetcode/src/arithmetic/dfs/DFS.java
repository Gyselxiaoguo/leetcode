package arithmetic.dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    // 用来存放遍历结果的集合
    private List<Integer> res = new ArrayList<>();

    // 递归实现深度优先遍历
    private void myDFS(TreeNode node) {
        // 递归终止条件
        if (node == null) return;
        // 1. 先访问当前节点
        res.add(node.val);
        // 2. 递归遍历左子树（一直往左走）
        myDFS(node.left);
        // 3. 递归遍历右子树（左边走不通再走右边）
        myDFS(node.right);
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