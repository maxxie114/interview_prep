// leetcode 103: Binary Tree Zig Zag Level Traversal
// Submission: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1550197240

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // edge case
        if (root == null) {
            return new ArrayList<>();
        }

        // First we need an empty arraylist to store the result
        List<List<Integer>> result = new ArrayList<>();

        // Now we need a queue for the bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Now we start the main while loop for the traversal
        int layer = 0;
        while (!q.isEmpty()) {
            // get the count for the current layer and create a new empty arraylist
            int count = q.size();
            List<Integer> level = new ArrayList<>();

            // loop exact count times to add everything into the level array
            for (int i = 0; i < count; i++) {
                // dequeue each items, and check if each of them have child nodes, if they do, they push to queue
                // Also add each of the cur node to the level array
                TreeNode cur = q.remove();
                level.add(cur.val);

                // check left and right child
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            // check if this layer should be normal or opposite, for any odd number layers, the traversal need to be flipped
            if (layer % 2 != 0) {
                // inverse the array
                List<Integer> level_inv = new ArrayList<>();
                for (int i = level.size() - 1; i >= 0; i--) {
                    level_inv.add(level.get(i));
                }
                result.add(level_inv);
            } else {
                // push the level array onto the result array if it is not inversed
                result.add(level);
            }
            // keep track of the layer
            layer++;
        }

        // return the final result
        return result;
    }
}