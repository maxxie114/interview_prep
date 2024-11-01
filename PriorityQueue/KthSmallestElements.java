import java.util.*;

// Solution for leetcode 378
class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new MyComparator()); // Min-heap based on the value of elements
        for (int i = 0; i < n; i++) {
            // Initialize the heap with the elements in the first column
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int count = 0;
        int kthSmallest = -1;
        
        while (count < k) {
            int[] current = pq.poll();
            kthSmallest = current[0];
            int row = current[1];
            int col = current[2];
            count++;
            
            // If there's a next element in the row, add it to the heap
            if (col + 1 < n) {
                pq.add(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return kthSmallest;
    }

    public static void main(String[] args) {
        KthSmallestElement solution = new KthSmallestElement();
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println(solution.kthSmallest(matrix, k)); // Output: 13
    }
}

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}