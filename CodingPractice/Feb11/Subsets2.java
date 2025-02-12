// Solution for leetcode 90: subsets 2
// Submission: https://leetcode.com/problems/subsets-ii/submissions/1540144620
import java.util.*;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // First we need an array to store the result and the current combination
        List<List<Integer>> result = new ArrayList<>(); 
        ArrayList<Integer> curCombination = new ArrayList<>();
        // Since there are repeated items that may not be in order, we need to sort it to avoid errors
        Arrays.sort(nums);
        // run a dfs with the result, the result combination, the input nums and layer as input
        int layer = 0;
        dfs(result, curCombination, nums, layer);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> curCombination, int[] nums, int layer) {        
        // base case: if the layer is the same as the length of the nums
        // this indicates that it has reached the end of the tree so we record and return the current combination
        if (layer == nums.length) {
            // adding a copy of the curCombination into the result arraylist to avoid issues
            result.add(new ArrayList<>(curCombination));
            return;
        }

        // recursion case: if it is not yet at the last layer, then we add the current layer into the curCombination, and do a dfs for the next layer
        curCombination.add(nums[layer]); // add the value that represent the current layer into the curCombination
        dfs(result, curCombination, nums, layer + 1); // run dfs for the next layer
        curCombination.remove(curCombination.size() - 1); // remove the last item added to the curCombination

        // if the current layer is the same as the previous layer, we just skip that layer and not go into dfs
        // since there might be many repeated numbers, we have to iterate over all of them and skip them all
        // Here we have to compare the next layer with the previous layer, or else there would indexes that are out of bound of the nums
        while(layer + 1 < nums.length && nums[layer + 1] == nums[layer]) {
            layer++;
        }
        // after skiping all of the identical layer values, we have to do a dfs again
        dfs(result, curCombination, nums, layer + 1);
    }
}