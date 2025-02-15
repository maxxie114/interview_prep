// Solution for leetcode 108: Convert Sorted Array to BST
// Submission: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/1543363069
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // edge case
        if (nums.length == 0) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        // recursively build the left and right subtree
        node.left = dfs(nums, left, mid-1);
        node.right = dfs(nums, mid+1,right);

        return node;
    }
}