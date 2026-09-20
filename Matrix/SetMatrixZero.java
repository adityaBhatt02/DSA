/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

example 1 -
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

example 2 -
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */


/*
O(m * n) - Time Complexity
O(m + n) - Space Complexity        { Becz creating 2 arrays of size m and n }
 */
class SetMatrixZeroApproachI {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rows[i] || cols[j]) matrix[i][j] = 0;
            }
        }
    }
}

/*
Same time complexity but space complexity is now O(1) woahh.

In the O(m+n) solution, we had two separate arrays:
boolean[] rows;
boolean[] cols;

They answered:
rows[i] = true  → row i needs to become 0
cols[j] = true  → column j needs to become 0

But those arrays consume extra space.

So we ask:
Can the matrix itself store this information?
Yes.

We use:
matrix[i][0] → tells us whether ROW i should become 0
matrix[0][j] → tells us whether COLUMN j should become 0
*/
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        /*
        if there is already a 0 in the first row or first col.
        We are using the first row as our column-marker storage and first column as our row-marker storage.
        So if we just scan and modify the matrix, we can't tell:
        Was this 0 originally in the first row?
        or
        Did we put this 0 there later as a marker?
        so that's why if:
        firstRow = true
        → The ORIGINAL first row contained a zero.

        firstCol = true
        → The ORIGINAL first column contained a zero.

         */
        boolean firstRow = false, firstCol = false;

        // checking first row
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        // checking first column
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // using first row and first column as marker
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // setting inner cells to 0 using marker
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        // zero first row
        if(firstRow) {
            for(int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // zero first column
        if(firstCol) {
            for(int i = 0; i < m; i++) matrix[i][0] = 0;
            }
        }
}