// Solution for leetcode 700: Search in a Binary Search Tree
// Solution: https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/1520170492
public class SearchBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        // edge case: if root is null, return null
        if (root == null) {
            return null;
        }

        // base case: if the root value is equal to the value, return the root
        if (root.val == val) {
            return root;
        }

        // if the value is less than the root value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // if the value is greater than the root value, search in the right subtree
        return searchBST(root.right, val);
    }
}


// Definition for a binary tree node.
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
