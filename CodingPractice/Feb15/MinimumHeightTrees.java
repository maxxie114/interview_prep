// Leetcode 310: Minimum Height Trees
// Submission: https://leetcode.com/problems/minimum-height-trees/submissions/1544608047

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // edge case: if the number of nodes is 1, that means only one node would be the result
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        // Now, since this is topological sort, we need to have an adjList, and an indegree array to track the degrees
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];

        // initialize the adjList and the indegree array
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            indegree[i] = 0;
        }

        // populate the adjList and the indegree array, since this is an undirected edge, we have to add the same node as a prerequisite for each other
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            
            // update indegree for each other
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        // initialize the queue, for this one, we are looking for any nodes that are leaf nodes, which means they have 1 or 0 neighbors, so indegree of 1
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.add(i);
            }
        }

        // trim all the leafs from the tree until only 1 or 2 nodes remain, and that will represent the minimum height tree
        int remainingNodes = n;

        // Trim the tree of all the leafs
        while (remainingNodes > 2) {
            int size = q.size();
            // we are trying to remove all of the leaf nodes, so we delete them all from the remainingNodes
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.remove();
                // loop through all neighbors and decrement the indegree count
                for (int neighbor: adjList.get(leaf)) {
                    indegree[neighbor]--;
                    // if after removing the leafs, some new nodes end up having only one edges, then it is a new leaf node
                    if (indegree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>(q);
        return result;
    }
}