import java.util.*;

// Solution for leetcode 102: Binary Tree Level Order Traversal
// Submission: https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/1475361086
public class BiarnyTreeLevelOrderTraversal {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        if (root == null) {
            return result; // If the root is null, return an empty result
        }

        Queue<TreeNode> q = new LinkedList<>(); // Initialize the queue
        q.add(root); // Add root to the queue

        while (!q.isEmpty()) {
            int size = q.size(); // Get the size of the current level
            List<Integer> curResult = new ArrayList<>(); // List for current level result

            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll(); // Get the current node
                curResult.add(curNode.val);  // Add current node's value to current result list

                if (curNode.left != null) {
                    q.add(curNode.left); // Add left child to the queue if it exists
                }
                if (curNode.right != null) {
                    q.add(curNode.right); // Add right child to the queue if it exists
                }
            }
            result.add(curResult); // Add the current level result to the final result
        }

        return result; // Return the final result list
    }
}