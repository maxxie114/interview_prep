import java.util.*;

public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // edge case
        if (root == null) {
            return result;
        }   
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);


        while (!q.isEmpty()) {
            int size = q.size();
            // keep track of the layers
            int layer = result.size();
            // keep track of the result of each layer
            LinkedList<Integer> curResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // even left → right	
                if (layer % 2 == 0) {
                    curResult.add(node.val);
                } else {
                    curResult.addFirst(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(curResult);
        }
        return result; 
    }
}
