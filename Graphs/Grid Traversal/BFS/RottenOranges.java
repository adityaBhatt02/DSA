public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;                // if there are no fresh oranges so the rotten orange can not rot ofco

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
        int minutes = 1;
        /* we are starting from 1 not 0 becz, at minute 1 the rottening happens and when the level ends we increase the minute,
        even when the next level is not started becz no. fresh oranges can get to 0 in b/w of the next level so, we need to have
        the minutes at correct level time not after we processed and the whole level */

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();

                for(int[] direction : directions) {
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];

                    if(row < 0 || row >= rows || col < 0 || col >= cols) continue;

                    if(grid[row][col] == 1) {
                        grid[row][col] = 2;

                        fresh--;
                        if(fresh == 0) return minutes;

                        queue.offer(new int[]{row,col});
                    }
                }
            }
            minutes++;
        }

        return -1;
    }
}


