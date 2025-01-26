// Leetcode Submission: https://leetcode.com/problems/validate-binary-search-tree/submissions/1520522013
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        // call the dfs function, and default the min and max value to null
	    // Note that we can’t directly pass null into int variables, it needs to be Integer
        return validBST(root, null, null);
    }

    private boolean validBST(TreeNode curNode, Integer min, Integer max) {
        // base case: if the node is null, return true
        if (curNode == null) {
            return true;
        }

        // if （curNode > min && curNode < Max), then the curNode is valid, and then we check if the left subtree and the right subtree are valid, return (validBST(node.left) && validBST(node.right))
        boolean left = validBST(curNode.left, min, curNode.val); // dfs start from the left child node, where min is the min that is passed down, the max is the current node val
        boolean right = validBST(curNode.right, curNode.val, max); // dfs start from the right child node, where min is the val of the curNode since everything need to be bigger than the min, and max is just the max that is passed down from previous recursion

        // if both the min and the max is null, that means this is the root node, so we return the result from the left child && the right child
        if (min == null && max == null) {
            return left && right;
        }

        // if min is null, that means this is a left child node, so we check if the information passed up to this node are valid, as well as if this node itself is valid (if it is less than max, its valid)
        if (min == null) {
            return left && right && curNode.val < max;
        }

        // if max is null, that means this is a right child node, so we check if the information passed up to this node are valid, as well as checking if it is bigger than min, if it is then the curNode is also valid
        if (max == null) {
            return left && right && curNode.val > min;
        }

        // finally we check if everything is valid by checking if the node is in the range of min and max, and if the information passed up to this node are also valid
        return left && right && curNode.val < max && curNode.val > min;
    }
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int val) {
		this.val = val;
    }
}