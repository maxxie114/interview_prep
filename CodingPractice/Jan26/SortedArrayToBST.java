// Leetcode 108:  Convert Sorted Array to Binary Search Tree
public class SortedArrayToBST {
    // Algorithm: The difference between a sorted array and a bst is that in a sorted array, the middle element is the root of a bst, since everything at the left of mid is smaller, everything at the right of mid is bigger, so we can just use this idea to recursively build the bst
    // Submission: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/1521975290
    public TreeNode sortedArrayToBST(int[] nums) {
        // call the DFS
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        // base case: if the input is invalid, that left is bigger than right
        if (left > right) {
            return null;
        }

        // get the middle, and use the mid as a root, build a mid node
        int mid = left + (right - left) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        // recursively build the left and right subtree from the mid node
        midNode.left = sortedArrayToBST(nums, left, mid - 1); // left subtree is from the current left, to mid - 1, the mid item is ignored since thats already the root
        midNode.right = sortedArrayToBST(nums, mid + 1, right); // right subtree is from the current mid + 1 to current right

        // Finally, we return the treenode
        return midNode;
    }
}


// Definition for a binary tree node.
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
