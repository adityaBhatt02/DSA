/*
Time : O(rows * cols) -- each cell is processed at most once.
Space : O(rows * cols) -- the queue can hold up to that many cells.
 */

public class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;

        int original = image[sr][sc];
        if(original == color) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        image[sr][sc] = color;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};             // top, bottom, left, right

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();   // the current cell which we already processed but now doing for its neighbors

            for(int[] direction : directions) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];

                if(row >= rows || row < 0 || col >= cols || col < 0) continue;

                if(image[row][col] == original) {
                    image[row][col] = color;
                    queue.offer(new int[]{row, col});
                }
            }
        }
        return image;
    }
}