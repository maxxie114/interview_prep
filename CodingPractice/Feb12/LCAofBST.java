// Solution for leetcode 235: lowest common ancestor of a BST
// Submission: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/1543375715
class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge case: if the root node is null, just return
        if (root == null) {
            return null;
        }

        // recursion case: if the value of p and the value of q are both smaller than the root node, we traverse the left tree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        
        // recursion case: if the value of p and the value of q are both bigger than the root node, we traverse the right tree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        
        // if it is none of the above case, then the current node would be the LCA, so we just return the root node
        else {
            return root;
        }
    }
}