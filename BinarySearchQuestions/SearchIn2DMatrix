/* 
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int start = 0, end = rows * cols - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            int row = mid / cols, col = mid % cols;

            if(matrix[row][col] == target) {
                return true;
            }else if(matrix[row][col] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }
}
