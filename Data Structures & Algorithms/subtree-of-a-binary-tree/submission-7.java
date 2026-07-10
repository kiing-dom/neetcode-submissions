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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        if (isSame(root, subRoot)) return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isSubtree(left, subRoot) || isSubtree(right, subRoot);
    }

    private boolean isSame(TreeNode r, TreeNode sr) {
        if (r == null && sr == null) return true;

        if (r == null || sr == null || r.val != sr.val) {
            return false;
        }

        boolean isSameLeft = isSame(r.left, sr.left);
        boolean isSameRight = isSame(r.right, sr.right);

        return isSameLeft && isSameRight;
    }
}

/**
    given:
    - root: TreeNode
    - subRoot: TreeNode

    return:
    - true: if there is a subtree of root with the same structure and node values of subRoot
    - false: if nto
 */