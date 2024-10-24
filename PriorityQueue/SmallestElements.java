import java.util.*;

// Solution for leetcode 378: Kth Smallest Element in a Sorted Matrix
class SmallestElements {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k > matrix.length * matrix[0].length) { 
            return Integer.MIN_VALUE;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());

        visited[0][0] = true;
        pq.add(new int[]{0, 0, matrix[0][0]});
        int result = Integer.MIN_VALUE;

        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            
            int curRow = cur[0];
            int curCol = cur[1];
            result = matrix[curRow][curCol];

            // Lookup to the right
            int rightCol = curCol + 1;
            if (rightCol < matrix[0].length && !visited[curRow][rightCol]) {
                pq.add(new int[]{curRow, rightCol, matrix[curRow][rightCol]});
                visited[curRow][rightCol] = true;
            }


            // Lookup to the under
            int downRow = curRow + 1;
            if (downRow < matrix.length && !visited[downRow][curCol]) {
                pq.add(new int[] {downRow, curCol, matrix[downRow][curCol]});
                visited[downRow][curCol] = true;
            }
        }

        return result;
    }
}

class MyComparator implements Comparator<int[]> {
    // int[]
    // 0: row
    // 1: col
    // 2: value
    @Override
    public int compare(int[] first, int[] second) {
        if (first[2] == second[2]) {
            return 0;
        }
        return first[2] < second[2] ? -1 : 1;
    }
}

/*

[[1, 5, 9],
 [10,11,13],
 [12,13,15]]

 [1,5,9,10,11,12,13,13,15]

 k = 8

 PQ:      15
 K: 0
 Result: 13
*/
