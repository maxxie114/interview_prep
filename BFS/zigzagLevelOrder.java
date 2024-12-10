import java.util.*;

import javax.swing.tree.TreeNode;

// Solution to Leetcode 103: Zigzag Level Order Traversal
// Submission: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1475364392
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Handle edge case where root is null
        if (root == null) {
            return result;
        }
        
        // Queue to perform BFS
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int layer = result.size();
            LinkedList<Integer> curResult = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                // Decide the order to add elements
                if (layer % 2 == 0) {
                    curResult.add(node.val);
                } else {
                    curResult.addFirst(node.val);
                }

                // Enqueue left and right children
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // Add the current level result to the final result
            result.add(curResult);
        }
        return result;
    }
}
