// Solution for leetcode 199: Binary Tree Right Side View
// Submission: https://leetcode.com/problems/binary-tree-right-side-view/submissions/1537588716

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rightSideItems = new ArrayList<>(); // Create an arraylist to keep track of all the right side items
        dfs(rightSideItems, root, 0); // Start the dfs traversal from level 0, with the rideSideItems and the root node as the input
        return rightSideItems;
    }

    private void dfs(ArrayList<Integer> rightSideItems, TreeNode node, Integer level) {
        // base case: if the node is null, just return
        if (node == null) {
            return;
        }

        // recursion case: traverse the right and left child, if nothing in the current level is added to the rightSideItems, add the right node into it
        if (rightSideItems.size() == level) {
            rightSideItems.add(node.val); // if the size is equal to the current layer, add the value of the current node into the result
        } // Do this first so the result doesn't get affected by the two subtree dfs
        dfs(rightSideItems, node.right, level + 1); // dfs for right child at next level
        dfs(rightSideItems, node.left, level + 1); // dfs for left child at next level
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}