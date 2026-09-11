public class GraphAdjMatrix {
    private int vertices;
    private int[][] adjMatrix;

    Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void addVertex() {
        int[][] newAdjMatrix = new int[vertices + 1][vertices + 1];

        for(int i = 0; i < adjMatrix.length; i++) {
            for(int j = 0; j < adjMatrix[i].length; j++) newAdjMatrix[i][j] = adjMatrix[i][j];
        }
        adjMatrix = newAdjMatrix;                         // adjMatrix references to now newAdjMatrix so old one gets garbage collected
        vertices++;
    }

    public void removeVertex(int vertex) {
        int[][] newAdjMatrix = new int[vertices - 1][vertices - 1];

        for(int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if(i != vertex && j != vertex) newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMatrix;
        vertices--;
    }
}