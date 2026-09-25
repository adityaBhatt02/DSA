/*
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v]
denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.
Note: The graph can have multiple component.

Examples:
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true

Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false

Input: V = 8, edges[][] = [[0 1], [2 3], [3 4], [5 6], [6 7], [5 7]]
Output: true


Cycle detection logic in undirected graph is that if you come accross a node that is already been visited and is not the parent
node then the cycle is present in that graph.
 */

public class UndirectedGraphDFS {
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Creates list for every vertex
        for(int i = 0; i < V; i++) adjList.put(i, new ArrayList<>());

        // Build undirected graph
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        boolean[] visited = new boolean[V];

        // For every component(graph may have multiple components)
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, adjList, visited)) return true;           // cycle in a component, i.e, cycle in the graph
            }

        }
        return false;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(neighbor == parent) continue;

            if(visited[neighbor]) return true;            // its a cycle

            if(dfs(neighbor, node, adjList, visited)) return true;
        }
        return false;
    }
}