// Leetcode 199: Binary Tree Right Side View
// Submission: https://leetcode.com/problems/binary-tree-right-side-view/submissions/1547970624
import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // Create an array to store the result, and also create a layer variable starting at 0
        List<Integer> result = new ArrayList<>();
        int layer = 0;

        // start a dfs, starting at layer 0, with the root node, layer, and result as output
        dfs(root, result, layer);

        return result;
    }

    // dfs function, with the result, layer, and root node as input
    private void dfs(TreeNode root, List<Integer> result, int layer) {
        // base case: if it hit a null, then it has reached a leaf, just return
        if (root == null) {
            return;
        }

        // recursion case: add the current node into the result array iff the an item at this layer is not yet added into the result array
        // here we need to use result.size() == layer, since if we use <, then the item at layer 0 will not be added, since 0 is not less than 0
        if (result.size() == layer) {
            result.add(root.val); // after the addition, result.size() becomes layer + 1, so when we check for the next layer, the result.size() will be equal layer.
        }
        // traverse the right subtree first, and then the left subtree
        dfs(root.right, result, layer + 1);
        dfs(root.left, result, layer + 1);
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