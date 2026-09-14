class DfsIterative {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create Adjacency List
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        // Add edges(undirected graph)
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        while(!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if(currentVertex == destination) return true;

            if(visited.contains(currentVertex)) continue;

            visited.add(currentVertex);
            for(int neighbor : graph.get(currentVertex)) {
                if(!visited.contains(neighbor)) stack.push(neighbor);
            }
        }
        return false;
    }
}