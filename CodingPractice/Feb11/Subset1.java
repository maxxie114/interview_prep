// Solution for leetcode 78: Subset I
// Submission: https://leetcode.com/problems/subsets/submissions/1540044216

import java.util.ArrayList;
import java.util.List;

class Subset1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // list that hold all results
        List<Integer> curSubset = new ArrayList<>(); // list that hold current subset
        // run dfs with the intial layer, curSubset, result, and nums array as input
        int layer = 0;
        dfs(nums, layer, curSubset, result);
        return result;       
    }

    // dfs function, keeping track of the layer, curSubset, and result
    private void dfs(int[] nums, int layer, List<Integer> curSubset, List<List<Integer>> result) {
        // base case: if it reaches the last layer, then add to the result array and return
        if (layer == nums.length) {
            result.add(new ArrayList<>(curSubset));
            return;
        }

        // left child case: the result subset does not include the current item/index 
        dfs(nums, layer + 1, curSubset, result);

        // right child case: the current item/index is included in the result subset
        // we first add the current item into the result subset, then we do a dfs
        curSubset.add(nums[layer]); // add the index at current layer to the result subset
        dfs(nums, layer + 1, curSubset, result);
        curSubset.remove(curSubset.size() - 1); // backtrack the status of the curSubset content by removing the last element
    }
}