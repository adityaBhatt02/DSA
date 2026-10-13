public class CourseSchedule2DFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());

        for(int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];

            adjList.get(source).add(destination);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(dfs(i, adjList, visited, pathVisited, stack)) return new int[]{};
            }
        }

        int[] order = new int[numCourses];
        int i = 0;

        while(!stack.isEmpty()) order[i++] = stack.pop();

        return order;
    }

    private boolean dfs(int currentNode, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack) {
        visited[currentNode] = true;
        pathVisited[currentNode] = true;

        for(int neighbour : adjList.get(currentNode)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, adjList, visited, pathVisited, stack)) return true;
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[currentNode] = false;
        stack.push(currentNode);

        return false;
    }
}