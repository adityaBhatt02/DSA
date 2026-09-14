/*
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:
-> Begin with the starting pixel and change its color to color.
-> Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either
horizontally or vertically) and shares the same color as the starting pixel.
-> Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
-> The process stops when there are no more adjacent pixels of the original color to update.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
 */

public class FloodFill {
    private int rows, cols;

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        int currentColor = image[sr][sc];
        if(currentColor == color) return image;

        dfs(sr, sc, color, currentColor, image);
        return image;
    }

    private void dfs(int row, int col, int color, int currentColor, int[][] image) {

        // out-of-bound case
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;

        // pixel not equal to currentColor
        if(image[row][col] != currentColor) return;

        image[row][col] = color;

        dfs(row - 1, col, color, currentColor, visited, image); // up
        dfs(row + 1, col, color, currentColor, visited, image); // down
        dfs(row, col + 1, color, currentColor, visited, image); // left
        dfs(row, col - 1, color, currentColor, visited, image); // right
    }
}