PUBLIC class BfsIterative {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        boolean[] visited = new boolean[n];

        return bfs(source, destination, adjList, visited);
    }

    private boolean bfs(int source, int destination, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            if(currentNode == destination) return true;

            for(int neighbor : adjList.get(currentNode)) {
                if(!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false;
    }
}
