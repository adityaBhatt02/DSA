import java.util.*;

/*
Complexity:
O(V+E) time
O(V+E) space.
 */

public class TopologicalSortBFS {
    public static List<Integer> topoSort(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] inDegree = new int[V];

        for(int i = 0; i < V; i++) map.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            map.get(source).add(destination);
            inDegree[destination]++;
        }

        // Add all zero-inDegree vertices to the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        // process vertices using BFS
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            order.add(currentNode);

            for(int neighbour : adjList.get(currentNode)) {
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        /*
        No cycle: Every vertex can eventually reach indegree 0. Kahn's Algorithm processes all V vertices,
        so order.size() == V.
        Cycle exists: The vertices in the cycle cannot be processed because they retain incoming edges from within the cycle.
        Some vertices remain unprocessed, so order.size() < V.
         */
        if(order.size() != V) return new ArrayList<>();

        return order;
    }
}