public class leetcode314 {
    function verticalOrder(TreeNode root) {
        if (root is null) {
            return an empty list
        }

        // Step 1: Initialize data structures
        Map<Integer, List<Integer>> columnTable = new HashMap<>()
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>()
        int minHd = 0
        int maxHd = 0

        // Start BFS from the root, horizontal distance (hd) is 0 for root
        enqueue(queue, new Pair(root, 0))

        // Step 2: Perform BFS traversal
        while (queue is not empty) {
            // Dequeue an element from the queue
            Pair<TreeNode, Integer> pair = dequeue(queue)
            TreeNode node = pair.key
            int hd = pair.value

            // Add node value to the column table
            if (!columnTable.containsKey(hd)) {
                columnTable.put(hd, new ArrayList<>())
            }
            columnTable.get(hd).add(node.val)

            // Update min and max horizontal distances
            minHd = min(minHd, hd)
            maxHd = max(maxHd, hd)

            // Enqueue left child with horizontal distance hd - 1
            if (node.left is not null) {
                enqueue(queue, new Pair(node.left, hd - 1))
            }

            // Enqueue right child with horizontal distance hd + 1
            if (node.right is not null) {
                enqueue(queue, new Pair(node.right, hd + 1))
            }
        }

        // Step 3: Construct result from the column table
        List<List<Integer>> result = new ArrayList<>()
        for (int hd = minHd; hd <= maxHd; hd++) {
            result.add(columnTable.get(hd))
        }

        return result
    }
}
