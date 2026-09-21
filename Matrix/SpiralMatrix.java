/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


The simplest way to think about it
Every time you process a boundary, you shrink it:

Go right  → top++
Go down   → right--
Go left   → bottom--
Go up     → left++
But after shrinking, there might not be anything left in that direction.

So:
if (top <= bottom)
    → Is there still a row?

if (left <= right)
    → Is there still a column?
*/


public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;

            for(int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            if(left <= right) {
                for(int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }    
        return result;
    }
}
