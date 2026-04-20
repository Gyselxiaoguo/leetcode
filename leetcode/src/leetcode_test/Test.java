package leetcode_test;


import java.util.ArrayDeque;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {



    }

    //广度优先遍历
    private void BFS(TreeNode root){
        Queue<Integer> queue=new ArrayDeque<>();
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