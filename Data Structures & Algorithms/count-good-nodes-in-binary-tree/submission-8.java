/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, -10001);
        return count;
    }

    private void dfs(TreeNode node, int currentMax) {
        if (node == null) return;

        if (node.val >= currentMax) {
            count++;
            currentMax = Math.max(currentMax, node.val);
        }

        dfs(node.left, currentMax);
        dfs(node.right, currentMax);
    } 
}