public class IsGraphBipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++) {
            if(color[i] == 0) {
                if(!bfs(i, 1, graph, color)) return false;
            }
        }
        return true;
    }

    private boolean bfs(int node, int currentColor, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        color[node] = currentColor;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            for(int neighbour : graph[currentNode]) {
                if(color[neighbour] == color[currentNode]) return false;

                if(color[neighbour] == 0) {
                    queue.offer(neighbour);
                    color[neighbour] = -color[currentNode];
                }
            }
        }
        return true;
    }
}