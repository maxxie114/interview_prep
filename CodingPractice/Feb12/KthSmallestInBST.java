// Solution for leetcode 230: Kth smallest element in a BST
// Submission: https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/1542683092
public class kthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        // initialize a counter and a result integer
        // Here we have to use an int array since Integer can't be passed directly into the dfs
        int[] count = new int[1];
        int[] result = new int[1];
        dfs(root, k, count, result);
        return result[0];
    }

    // dfs with the root node, target k, count and result as input
    private void dfs(TreeNode root, int k, int[] count, int[] result) {
        // base case: if the node is null, we have reached a leaf, so we return
        if (root == null) {
            return;
        }

        // recursion case: if it is not null, we first traverse the left subtree
        dfs(root.left, k, count, result);

        // process the current node, since we are looking for the kth element, we first increment the counter variable
        count[0]++;
        // if the count is the same as k, then we have found that node, so we record it as result
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }

        // if the k element still haven't been found after traversing the entire left subtree, then we go for the right subtree
        dfs(root.right, k, count, result);
    }
}