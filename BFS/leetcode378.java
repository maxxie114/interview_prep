public class leetcode378 {
    function kthSmallest(matrix, k) {
        int n = length of matrix // Get the dimension of the matrix (assumed square)
        // Create a priority queue (min-heap) to store elements as [value, row, col]
        PriorityQueue pq = new PriorityQueue(comparator comparing array elements by their value)

        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            add to pq the tuple [matrix[i][0], i, 0]  // value, row index, column index
        }

        int count = 0
        int kthSmallest = -1

        // Extract elements from the heap k times to find the k-th smallest element
        while (count < k) {
            // Remove the smallest element from the heap
            array current = poll from pq
            kthSmallest = current[0]  // Get the value
            int row = current[1]      // Get the row index
            int col = current[2]      // Get the col index
            count++

            // Add the next element in the current row to the heap, if it exists
            if (col + 1 < n) {
                add to pq the tuple [matrix[row][col + 1], row, col + 1]
            }
        }

        return kthSmallest
    }
}
