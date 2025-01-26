// Solution for leetcode 230: Kth Smallest Element in a BST
// Solution: https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/1520199072
public class KthSmallestElementinBST {
    public int kthSmallest(TreeNode root, int k) {
        // initialize the result array, and call the helper function
        // initialize the kleft array, to store the kth smallest element
        int[] result = new int[]{0}; // result[0] is the counter
        int[] kleft = new int[]{k}; // kleft[0] is the kth smallest element
        recursion(root, result, kleft, k); // call the helper function
        return kleft[0]; // return the kth smallest element
    }

    // helper function to find the kth smallest element
    // add a counter to keep track of the number of elements visited
    private void recursion(TreeNode root, int[] result, int[] kleft, int k) {
        // edge case: if the root is null, return
        if (root == null) {
            return;
        }
        
        // This is inorder traversal, so left, root, right
        // traverse the left child
        recursion(root.left, result, kleft, k);


        // increment the counter
        result[0]++;

        // if the counter is equal to k, then we have found the kth smallest element
        // store the kth smallest element in kleft[0]
        // the if statement here uses compares result[0] with k instead of comparing result[0] with kleft[0], because we want to store the kth smallest element only once
        if (result[0] == k) {
            kleft[0] = root.val;
            return;
        }

        // if the counter is not equal to k, then we have not found the kth smallest element
        // traverse the right child
        recursion(root.right, result, kleft, k);
    }
}
