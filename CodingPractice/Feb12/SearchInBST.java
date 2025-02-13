// Solution for leetcode 700: Search in a BST
// Submission: https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/1541271682
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        // base case: if the node is null, then we reached the end of the tree, so return
        if (root == null) {
            return null;
        }

        // base case: if the node is the target node, we have found the node, so we just return it
        if (root.val == val) {
            return root;
        }

        // recursion case: if we haven't reached the end, and we haven't found the node
        // we search the left subtree first if it is target is smaller than the root node, else we search the right subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
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