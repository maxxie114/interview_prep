// Leetcode 102: Binary Tree Level Order Traversal
// Submission: https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/1550187682
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            // push the level array onto the result array
            result.add(level);
        }

        // return the final result
        return result;
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
