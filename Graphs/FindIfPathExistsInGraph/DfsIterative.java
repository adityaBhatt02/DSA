public class DfsIterative {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Creates lists for each vertex
        for(int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());

        // Creates the adjacency list
        for(int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, adjList, visited);
    }

    private boolean dfs(int source, int destination, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        if(source == destination) return true;

        Stack<Integer> stack = new Stack<>();

        stack.add(source);
        visited[source] = true;

        while(!stack.isEmpty()) {
            int currentNode = stack.pop();

            if(currentNode == destination) return true;

            for(int neighbor : adjList.get(currentNode)) {
                if(!visited[neighbor]) {
                    stack.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false;
    }
}
