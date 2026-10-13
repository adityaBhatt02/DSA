/*
DFS can detect a cycle and stop immediately
As soon as DFS encounters a node that is already on the current recursion path, it has found a cycle. It immediately
returns, and your canFinish() can stop checking the remaining graph.

With BFS using Kahn’s algorithm, you typically:
-> Calculate the in-degree of each course.
-> Add all zero-in-degree courses to a queue.
-> Process the queue and reduce the in-degrees of neighbouring courses.
-> Check whether all courses were processed.

A cycle is identified when fewer than numCourses courses are processed. BFS may need to process a substantial part of the graph
before reaching that conclusion.


The important takeaway: DFS is not inherently faster than BFS. Both have O(V+E) time complexity here,
and the actual runtime depends on graph structure, traversal order, implementation overhead, and benchmarking variation.
 */

public class CourseSchedule1DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());

        for(int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];

            adjList.get(source).add(destination);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(dfs(i, adjList, visited, pathVisited)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int currentNode, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[currentNode] = true;
        pathVisited[currentNode] = true;

        for(int neighbour : adjList.get(currentNode)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, adjList, visited, pathVisited)) return true;
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[currentNode] = false;
        return false;
    }
}