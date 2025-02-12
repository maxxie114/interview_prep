import java.util.*;
// Solutions for leetcode 46: Permutations
// Submission: https://leetcode.com/problems/permutations/submissions/1540091000
public class Permutations1 {
    public List<List<Integer>> permute(int[] nums) {
        // intialize an arraylist to store the final result and the current result
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curPermutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // a boolean array to track if an index is used
        
        // call the dfs with the result, curPermutation, nums, and visited as the input
        dfs(nums, result, curPermutations, visited);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> curPermutations, boolean[] visited) {
        // base case: if the current permutation has the same length of the nums, meaning it contains all elements, add to the result and return it.
        if (curPermutations.size() == nums.length) {
            // add a copy so that it won't affect the final result
            result.add(new ArrayList<>(curPermutations));
            return;
        }

        // recursion case: traverse any index that haven't been used yet, and run dfs for them
        for (int i = 0; i < nums.length; i++) {
            // if a node is visited, since this is about permutations, we don't want to repeat that element again
            if (visited[i] == true) {
                continue;
            }

            // for anything that is not visited yet, add them to the curPermutations, and mark as visited
            visited[i] = true;
            curPermutations.add(nums[i]);

            // call dfs for any nodes that are not visited yet
            dfs(nums, result, curPermutations, visited);

            // backtrack the status, remove the last element from the curPermutations, and mark the current index as not visited
            curPermutations.remove(curPermutations.size() - 1);
            visited[i] = false;
        }
    }
}