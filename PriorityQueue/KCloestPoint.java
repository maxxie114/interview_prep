import java.util.*;

// Solution for leetcode 973: K Closest Points to Origin
public class KCloestPoint {
    public int[][] kClosest(int[][] points, int k) {
        // Empty edge case
        if (points == null || points.length == 0 || k <= 0) {
            return new int[0][0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        // Loop through all the points, calculate their distance and put them into the PQ
        for (int[] point : points) {
            pq.add(point); // Add the point to the priority queue
        }

        // Prepare the result array, and retrieve the k closest points from the priority queue
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        KCloestPoint solution = new KCloestPoint();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] closestPoints = solution.kClosest(points, k);
        System.out.println(Arrays.deepToString(closestPoints)); // Output: [[-2, 2], [1, 3]]
    }
}

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] first, int[] second) {
        // Calculate the distance from the origin using square distance
        int dist1 = first[0] * first[0] + first[1] * first[1];
        int dist2 = second[0] * second[0] + second[1] * second[1];
        
        // Compare the distances
        return dist1 < dist2 ? -1 : 1;
    }
}
