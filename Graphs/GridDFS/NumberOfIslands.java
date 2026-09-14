/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

public class NumberOfIslands {
    private int rows, cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid) {

        if(row < 0 || row >= rows || col < 0 || col >= cols) return;  // out of bound case
        if(grid[row][col] == 0) return;

        if(grid[row][col] == '1') {
            grid[row][col] = '0';

            dfs(row - 1, col, grid);
            dfs(row + 1, col, grid);
            dfs(row, col - 1, grid);
            dfs(row, col + 1, grid);
        }
    }
}

/*
My initial approach was to also use visited boolean matrix that will help with if the current cell is visited or not by true and false
but ofco it was taking extra space of O(row * col) and the recursive DFS also uses the same call stack, which in the worst case
can go up to: O(rows × cols)

So your auxiliary space is: O(rows × cols) + O(rows × cols)
which is still: O(rows × cols)
because we drop the constant factor.


But now in the current approach we are just changing '1' -> '0' representing visited for that particular cell so no need of extra
matrix so now the only auxiliary space in the worst case is the recursion stack: O(rows × cols)
So both are still O(rows × cols) asymptotically, but the this one uses less actual memory because it doesn't allocate another
matrix.
But we are manipulating the grid(input matrix) itself, so it is said dont manipulate the i/p then ofco use that extra space and use
visited matrix.
 */