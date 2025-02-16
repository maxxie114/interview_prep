// Leetcode 366: Find leaves of binary tree
// Submission: https://leetcode.com/problems/find-leaves-of-binary-tree/submissions/1544673466

import java.util.ArrayList;
import java.util.List;

public class LeafsOfBinTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // create a result arraylist
        List<List<Integer>> result = new ArrayList<>();

        // run a dfs with the result, the root node as the input
        dfs(result, root);

        return result;
    }

    private int dfs(List<List<Integer>> result, TreeNode root) {
        // base case: if the node is a null, we have hit a leaf node, so we can just return -1
        // since we use the max of leftHeight and rightHeight + 1 to determine the layer of the current root node, then max(-1,-1) + 1 = 0, so leaf node would be at layer 0
        if (root == null) {
            return -1;  
        }

        // run a dfs for the left and right tree, leftHeight and RightHeight track the layers of each of the subtree
        // Here we recursively calculate the height of the left and right subtree in order to use that to determine the current node's height
        int leftHeight = dfs(result, root.left);
        int rightHeight = dfs(result, root.right);

        // get the current height of the tree, by using the height of the highest subtree + 1, we can effectively get the height of the current root node
        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        // if the size of the result is the same as the current height, we add an empty list to the result to keep track of the layers
        // since the result arraylist start at size 0, we can then recursively add each layers as an empty list into the result arraylist
        if (result.size() == currentHeight) {
            result.add(new ArrayList<>());
        }

        // once we determined the height of the current node, we can add that to the corresponding layer in the result arraylist
        result.get(currentHeight).add(root.val);

        // This will return the height of the current subtree and pass information back to the parent node
        return currentHeight;
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