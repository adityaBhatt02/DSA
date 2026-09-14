
class FloodFillBFS {
    private int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        int currentColor = image[sr][sc];

        // avoid unnecessary traversal
        if (currentColor == color) return image;


        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check bounds
                if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Only process cells with original color
                if (image[newRow][newCol] != currentColor) {
                    continue;
                }

                // Mark visited immediately
                image[newRow][newCol] = color;

                queue.offer(new int[]{newRow, newCol});
            }
        }

        return image;
    }
}