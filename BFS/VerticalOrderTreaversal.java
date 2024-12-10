import java.util.*;

// Solution for LeetCode problem 314 Binary Tree Vertical Order Traversal
// Submission: https://leetcode.com/problems/binary-tree-vertical-order-traversal/submissions/1475369183
public class VerticalOrderTreaversal {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result; // Handle the edge case of an empty tree
        }

        // Step 1: Initialize data structures
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int minHd = 0;
        int maxHd = 0;

        // Start BFS from the root, horizontal distance (hd) is 0 for root
        queue.add(new Pair<>(root, 0));

        // Step 2: Perform BFS traversal
        while (!queue.isEmpty()) {
            // Dequeue an element from the queue
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int hd = pair.getValue();

            // Add node value to the column table
            columnTable.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.val);

            // Update min and max horizontal distances
            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            // Enqueue left child with horizontal distance hd - 1
            if (node.left != null) {
                queue.add(new Pair<>(node.left, hd - 1));
            }

            // Enqueue right child with horizontal distance hd + 1
            if (node.right != null) {
                queue.add(new Pair<>(node.right, hd + 1));
            }
        }

        // Step 3: Construct result from the column table
        for (int hd = minHd; hd <= maxHd; hd++) {
            result.add(columnTable.get(hd));
        }

        return result;
    }
}
