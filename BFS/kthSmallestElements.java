import java.util.*;
// Solution for leetcode 378: Kth Smallest Element in a Sorted Matrix
// Submissions: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/1475370978
public class kthSmallestElements {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; // Get the dimension of the matrix (assumed square)
        
        // Create a priority queue (min-heap) with a custom comparator to store elements
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{matrix[i][0], i, 0}); // value, row index, column index
        }

        int count = 0;
        int kthSmallest = -1;

        // Extract elements from the heap k times to find the k-th smallest element
        while (count < k) {
            // Remove the smallest element from the heap
            int[] current = pq.poll();
            kthSmallest = current[0];  // Get the value
            int row = current[1];      // Get the row index
            int col = current[2];      // Get the col index
            count++;

            // Add the next element in the current row to the heap, if it exists
            if (col + 1 < n) {
                pq.add(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return kthSmallest;
    }
}
