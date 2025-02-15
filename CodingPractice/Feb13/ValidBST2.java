// Solution for leetcode 98: Valid BST
// Submission: https://leetcode.com/problems/validate-binary-search-tree/submissions/1542610780

public class ValidBST2 {
    public boolean isValidBST(TreeNode root) {
        // Start with a lower and upper bound of null, since we haven't really started the validation yet
        return validBST(root, null, null);
    }
    // BST validation function with the root, lower and upper bound as input
    // lower bound is the lowest value that we can have, any numbers below the root node must be bigger than that value (applies to the right child)
    // upper bound is the highest value that we can have, any numbers below the root node must be smaller than that value (applies to the left child)
    private boolean validBST(TreeNode root, Integer lower, Integer upper) {
        // base case: if root node is a null, we have hit a leave node, so we can return a true
        if (root == null) {
            return true;
        }

        // base case: if the lower node is not null, and the value of the root node is less than or equal to the lower bound
        // then it is not a valid BST, return false
        // we check if the lower node is null first to avoid null pointer exception
        if (lower != null && root.val <= lower) {
            return false; 
        }

        // base case: if the root node is not null, and the value of the root node is more than or equal to the upper bound
        // then it is also not a valid BST, return false, null check for upper
        if (upper != null && root.val >= upper) {
            return false;
        }

        // recursion case: we first run a dfs for the left subtree, and check if they are valid, 
        // for the left subtree any number must be smaller than the root, so we set the root as the upper bound
        // if they are not valid, we return false
        if (!validBST(root.left, lower, root.val)) {
            return false;
        }

        // then we run a dfs for the right subtree, and we set the root value as the lower bound, any number must be bigger than the root node
        if (!validBST(root.right, root.val, upper)) {
            return false;
        }

        // if it did not hit any of the above cases, we just return true
        return true;
    }
}