// Leetcode 210: CourseSchedule2
// Submission: https://leetcode.com/problems/course-schedule-ii/submissions/1544461309

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // First create a graph and an indegree array, graph for mapping each course with its prerequisites, indegree array for how many prereq does one course have
        // The graph is an adjacency list, and the indegree array is an array of indexes
        List<List<Integer>> adjList = new ArrayList<>();     
        int[] indegree = new int[numCourses];

        // initialize the adjlist with arrays, and initialize the indegree with 0
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            indegree[i] = 0;
        }

        // build the graph and populate the adjlist
        for (int[] prereq: prerequisites) {
            // prereq[0] is the course, prereq[1] is the prerequisite
            // In the adjList, we are mapping each prereq to each course, so for an entire list of course, they all share the same prerequisite
            adjList.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        // Create a queue to store all courses with no prereq and a result array, add everything with 0 prereq into the queue
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Run the bfs, process the queue
        int count = 0; // for keep track of the result index
        while (!q.isEmpty()) {
            int course = q.remove();
            // add each course popped from the queue to the result
            result[count] = course;
            count++;

            // loop over all course neighboring this current course, since the current course is taken, all adjacency course would have its prereq reduced by 1
            // so we reduce them from the indegree array
            for (int neighbor: adjList.get(course)) {
                indegree[neighbor]--;
                // if it happens that one of those courses ended up with a 0 in the prereq after reduction
                // then we add that to the queue since there are no more prereq required for that course
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        // finally we check if the result is equal to the length of the course, if it is then all courses have been taken
        // if not then we can't finish all course, however, keep in mind that since this is an array, the result.length is always equal to numCourses.
        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}