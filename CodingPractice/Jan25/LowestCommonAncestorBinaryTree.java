// Solution for leetcode 236: Lowest Common Ancestor of a Binary Tree
// Submission: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/1520163585
public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge case: if root is null, return null
        if (root == null) {
            return null;
        }

        // base case: if root is either p or q, then we don't need to go further, return root
        if (root == p || root == q) {
            return root;
        }

        // recursive case: find the LCA in left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both left and right are not null, then root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // if left is not null, return left, otherwise return right
        return left != null ? left : right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
