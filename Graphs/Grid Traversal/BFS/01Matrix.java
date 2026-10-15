/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.

Example 1:
Input: mat = [[0,0,1], [1,1,1], [1,1,1]]
Output: [0,0,1], [1,1,2], [2,2,3]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


In multi-source BFS, put the cells you're measuring from into the queue. Here, we're measuring distance from the zeroes,
so all zeroes are our sources.

But why not put all 1s in the queue?
Because the queue's starting points determine what distance you calculate.

Start from all zeroes → find each cell's distance to its nearest zero.
Start from all ones → find each cell's distance to its nearest one, which is a different problem.
 */



/*
Time:
O(m×n). Each cell is enqueued and processed at most once.

Auxiliary space:
O(m×n). Your queue and visited array can both grow proportional to the number of cells.
 */
public class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }

        boolean[][] visited = new boolean[rows][cols];  // used the visited array to check that a particular cell has been already visited or not
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int distance = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();

                for(int[] direction : directions) {
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];

                    if(row < 0 || row >= rows || col < 0 || col >= cols) continue;

                    if(mat[row][col] == 1 && !(visited[row][col])) {
                        mat[row][col] = distance;
                        visited[row][col] = true;

                        queue.offer(new int[]{row,col});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}


/*
You can remove the visited array by using the matrix itself to track which cells haven't received a distance.

The challenge is that a cell whose distance is 1 still contains the value 1, so you can't distinguish it from an unvisited
cell using mat[row][col] == 1 alone.

Solution: Change every original 1 to Integer.MAX_VALUE before starting BFS. Keep all original zeroes at 0.
Then, when BFS reaches a cell containing Integer.MAX_VALUE, its distance hasn't been assigned yet.
 */
class OptimizedApproach {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int distance = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();

                for(int[] direction : directions) {
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];

                    if(row < 0 || row >= rows || col < 0 || col >= cols) continue;

                    if(mat[row][col] == Integer.MAX_VALUE) {
                        mat[row][col] = distance;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}