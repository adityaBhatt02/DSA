public class GraphAdjList {
    private Map<Integer, List<Integer>> adjList;

    // traversal
    private Set<Integer> visited = new HashSet<>();

    // for dfs iterative traversal
    private Stack<Integer> stack = new Stack<>();

    // for bfs iterative traversal
    private Queue<Integer> queue = new LinkedList<>();


    GraphAdjList() {
        this.adjList = new HashMap<>();
    }

    // for every new vertex creates new LinkedList
    public void addVertex(int vertex) {
        adjList.put(vertex, new LinkedList<>());
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);           // In source vertex's linkedlist add destination vertex
        adjList.get(destination).add(source);           // In destination vertex's linkedlist add source vertex
    }

    public void removeEdge(int source, int destination) {
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer) source);
    }

    public void removeVertex(int vertex) {
        adjList.remove(vertex);

        // Remove edges pointing to the removed vertex
        for(List<Integer> neighbour : adjList.values()) {
            neighbour.remove((Integer) vertex);
        }
    }

    /* Time Complexity -> O(V + E)
       Space Complexity -> O(V)
     */
    public void dfsIterative(int vertex) {
        stack.push(vertex);

        while(!stack.isEmpty()) {
            int currentVertex = stack.pop();
            visited.add(currentVertex);

            for(int neighbour : adjList.getOrDefault(currentVertex, Collections.emptyList())) {
                if(!visited.contains(neighbour)) stack.push(neighbour);
            }
        }
    }


    /* Time Complexity -> O(V + E)
       Space Complexity -> O(V)
    */
    public void dfs(int vertex) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(vertex, visited);
    }
    public void dfsRecursive(int vertex, Set<Integer> visisted) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for(int neighbour : adjList.getOrDefault(vertex, Collections.emptyList())) {
            if(!visisted.contains(neighbour)) dfsRecursive(neighbour, visisted);
        }
    }

    public void bfs(int vertex) {
        visited.add(vertex);
        queue.add(vertex);

        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for(int neighbour : adjList.getOrDefault(currentVertex, Collections.emptyList())) {
                if(!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}