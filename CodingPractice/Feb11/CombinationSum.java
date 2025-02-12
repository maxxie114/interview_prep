import java.util.*;
// Solution for leetcode 39: Combination Sum
// Submission: https://leetcode.com/problems/combination-sum/submissions/1540127945
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // First we need an array to track the result, and one to track the current candidate
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curCandidate = new ArrayList<>();
        // Now since this is combinations, there would be repeated items, and the order might not be in order, so we need to sort it first. 
        Arrays.sort(candidates);
        // Run the dfs with the candidate, target, curCandidate, and result as input, and starting at layer 0
        int layer = 0;
        dfs(candidates, target, curCandidate, result, layer);
        return result;
    }

    private void dfs(int[] candidates, int target, List<Integer> curCandidate, List<List<Integer>> result, int layer) {
        // base case: if target is exactly 0, that means we have found one combination, so we add a copy of the result and return
        if (target == 0) {
            result.add(new ArrayList<>(curCandidate));
            return;
        }

        // base case: if the target is a negative number, that means we over subtracted, so this combination would not be valid
        if (target < 0) {
            return;
        }

        // recursion case: for any cases where the target is not zero, iterate through each of the candidates
        // and run dfs on the result of which after this number is subtracted from the target number
        // iterates from the current layer (index) to the length of the candidates, that way anything before the current index would not be considered
        for (int i = layer; i < candidates.length; i++) {
            // first add the current candidate into the current combination
            curCandidate.add(candidates[i]);

            // Then we run a dfs for each of the index in the candidates, including index i, since the numbers are re-usable
            // In the DFS, we will use the number which current candidate subtracted from the target as the new target
            dfs(candidates, target - candidates[i], curCandidate, result, i);

            // backtrack the status by removing the last item from the curCandidate
            curCandidate.remove(curCandidate.size() - 1); 
        }
    }
}