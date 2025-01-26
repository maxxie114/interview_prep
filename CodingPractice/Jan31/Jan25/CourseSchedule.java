// Solution for leetcode 207: Course Schedule
// Solution: https://leetcode.com/problems/course-schedule/submissions/1520154152
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // initialize the in-degree array, stores prerequisite of each course, each course is an index, the the value means the amount of prereq this course have
        // initialize the adjacency list, which stores the courses that depend on each course, each sub-array in the adjlist stores all the courses that use the current course as a pre-requisite, that way it can be traversed from the current course
        // initialize the queue, stores all the courses that need to be traversed first (traverse from any courses with no pre-req)
        int[] inDegree = new int[numCourses]; 
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();


        
  // initialize the adjlist with numCourses amount of empty lists
        // for (int i = 0; i < numCourses; i++) {
        //    adjList.add(new ArrayList<>());
        // }


        // first add each course that depends on the current course to the adjlist, and then we increment indegree for each of the dependents courses
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            Arraylist<Integer> curList = adjList.get(prerequisiteCourse);
            if (curList == null) {
                adjList[prerequisiteCourse] = new ArrayList<>();
            }
            adjList.get(prerequisiteCourse).add(course);
            inDegree[course]++; // [0,1,2]
        }


        // we check the indegree array and see if any index have a 0, which means they have no prereq, we add that to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        // topological sort
        while (!queue.isEmpty()) {
		// poll from the queue any courses
            int course = queue.poll();
		// decrement numCourses, until all courses have been taken
            numCourses--;
		
		// get all coureses that is dependent on the current course
            for (int dependentCourse : adjList.get(course)) {
		    // decrement the indegree value for each of thoses course, since one dependency have already been taken
                inDegree[dependentCourse]--;
		    // if all these course, after decrement, have 0, meaning no more dependencies, we add that to the queue
                if (inDegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }
	  // if there are no more courses, then we return true, else false
        return numCourses == 0;
    }
}

