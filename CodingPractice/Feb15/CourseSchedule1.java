// Leetcode 207: Courese Schedule 1
// Submission: https://leetcode.com/problems/course-schedule/submissions/1543692817
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // The graph is an array of lists, each list represent one course
        List<List<Integer>> graph = new ArrayList<>();

        // Create an array that stores the indegree, indegree store the pre-requisite of each course
        int[] inDegree = new int[numCourses];

        // Initialize the value of the graph and the inDegree array, create an empty list of each course, 
        // and initialize pre-requisite of each course to 0
        for (int course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
            inDegree[course] = 0;
        }

        // Build the graph and populate the indegree array
        for (int[] prereq: prerequisites) {
            // append the prereq for each course, prereq[0] is course, prereq[1] is the prerequisites of that course
            graph.get(prereq[1]).add(prereq[0]);
            // increment the prereq for each course in the indegree array
            inDegree[prereq[0]]++;
        }

        // Build a queue to store the coureses with 0 prereqs, and initialize it with all course that does not have prereq
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // initialize a count
        int count = 0;

        // bfs for processing nodes
        while (!q.isEmpty()) {
            int currentCourse = q.remove();
            count++;

            // loop each neighbor nodes in the graph, and decrement their indegree count, since one prereq have already been taken.
            for (Integer neighbor: graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        // if count is equal to numCourses, this means all courses have been taken, so it would be a true, if not then all courses can't be finished
        return count == numCourses;
        
    }
}