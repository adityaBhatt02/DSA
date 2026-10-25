public class IsGraphBipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++) {
            if(color[i] == 0) {
                if(!dfs(i, 1, graph, color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int currentNode, int currentColor, int[][] graph, int[] color) {
        color[currentNode] = currentColor;

        for(int neighbour : graph[currentNode]) {
            if(color[neighbour] == 0) {
                if(!dfs(neighbour, -currentColor, graph, color))  return false;
            } else if(color[neighbour] == color[currentNode]) {
                return false;
            }
        }
        return true;
    }
}