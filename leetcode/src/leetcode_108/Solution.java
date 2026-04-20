package leetcode_108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nextNode(nums, 0, nums.length - 1);
    }
    public TreeNode nextNode(int[] nums, int l, int r) {
        // 递归终止条件：当 l > r 时返回 null
        if (l > r) {
            return null;
        }
        //1.找中间值mid
        int mid = (l + r) / 2;
        //2.生成节点
        TreeNode treeNode = new TreeNode(nums[mid]);
        //3.递归左节点
        treeNode.left=nextNode(nums,l,mid-1);
        //4.递归右节点
        treeNode.right=nextNode(nums,mid+1,r);
        return treeNode;
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
