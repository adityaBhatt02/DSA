/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.


Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false

Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

public class CourseSchedule1BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());

        for(int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];

            adjList.get(source).add(destination);
            inDegree[destination]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int courseCount = 0;
        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseCount++;

            for(int neighbour : adjList.get(currentCourse)) {
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        if(courseCount != numCourses) return false;

        return true;
    }
}

// same Kahn's algo code which is of cycle detection for directed graph but here 0,1 -> 1 is the source and 0 is the destination.
