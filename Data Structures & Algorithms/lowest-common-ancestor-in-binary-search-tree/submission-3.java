/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (p.val < node.val && q.val < node.val) {
            return findLCA(node.left, p, q);
        } else if (p.val > node.val && q.val > node.val) {
            return findLCA(node.right, p, q);
        } else {
            return node;
        }
    }
}

/**
    given:
    - root: binary search tree
    - p, q: nodes in the tree

    find: 
    - the LCA of nodes p and q within root
 */