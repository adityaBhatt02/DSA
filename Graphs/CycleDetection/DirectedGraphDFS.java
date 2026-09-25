/*
Given a directed graph with V vertices numbered from 0 to V - 1 and E directed edges. The graph is represented using a 2D array
edges[][] of size E, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.
Check whether the graph contains any cycle. Return true if there exists at least one cycle in the graph; otherwise, return false.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]
Output: true

Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: false


The mental model -----> Think of visited as your lifetime history and pathVisited as your current walking path.

visited -> "Have I EVER visited this node during the whole DFS?"
Once a node becomes: visited[node] = true;
it stays true.

pathVisited -> "Is this node STILL on the path I'm currently walking?"
When you enter a node: pathVisited[node] = true;

When you finish exploring that node and backtrack: pathVisited[node] = false;

 */

public class DirectedGraphDFS {
    public boolean isCyclic(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // create lists for every vertex
        for(int i = 0; i < V; i++) adjList.put(i, new ArrayList<>());

        // create adjacency list
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
        }

        boolean[] visited = new boolean[V];             // for whole dfs process
        boolean[] pathVisited = new boolean[V];         // for a particular dfs path

        // There can multiple coordinates in the graph
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, adjList, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, adjList, visited, pathVisited)) return true;
            } else if(pathVisited[neighbor]) return true;       // if that neighbor is visited but if it is visited in this particular dfs path then thats a cycle
        }

        pathVisited[node] = false;
        return false;
    }
}

/*
Now the important cases:
Suppose you're at X and you see neighbor Y.

Case 1 ->
visited[Y] = false
You have never seen Y.

So: DFS(Y)


Case 2 ->
visited[Y] = true
pathVisited[Y] = false
You've seen Y before, but Y is not in your current DFS path anymore.

So: already explored
→ don't DFS again
→ not a cycle


Case 3 ->
visited[Y] = true
pathVisited[Y] = true
You've seen Y before AND Y is still somewhere above you in your current DFS chain.
 */