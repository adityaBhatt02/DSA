/*
Logic is same as it's undirected only -> if parent is neigbor continue and if the neighbor is not parent and is visited already
return true.
And as it's bfs we use a queue that stores the current node and the parent node in an array and then check.

Examples:
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true

Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false

Input: V = 8, edges[][] = [[0 1], [2 3], [3 4], [5 6], [6 7], [5 7]]
Output: true
 */

public class UndirectedGraphBFS {
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
                if(bfs(i, adjList, visited)) return true;           // cycle in a component, i.e, cycle in the graph
            }

        }
        return false;
    }

    private boolean bfs(int start, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1});              // {current, parent}

        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];


            for(int neighbor : adjList.get(node)) {
                if(neighbor == parent) continue;

                if(visited[neighbor]) return true;            // its a cycle

                queue.offer(new int[]{neighbor, node});
                visited[neighbor] = true;
            }
        }
        return false;
    }
}