// Kahn's Algorithm
public class DirectedGraphBFS {
    public boolean isCyclic(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[V];

        for(int i = 0; i < V; i++) adjList.put(i, new ArrayList<>());

        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjList.get(source).add(destination);
            inDegree[destination]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        /*
        just like in topo sort we created and maintained the list for processed nodes here we dont need to store those nodes
        we can just simply count number of processed nodes if they are not equal to the number of vertices then there is cycle
        in the directed graph
         */
        int processedNodes = 0;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            processedNodes++;

            for(int neighbour : adjList.get(currentNode)) {
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        if(processedNodes != V) return true;

        return false;
    }
}