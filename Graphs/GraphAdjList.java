public class GraphAdjList {
    private Map<Integer, List<Integer>> adjList;

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
}