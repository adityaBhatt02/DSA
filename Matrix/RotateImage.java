/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Suppose:
1  2  3
4  5  6
7  8  9

For transpose, we want:
2 ↔ 4
3 ↔ 7
6 ↔ 8

Visual way to remember it
You're essentially flipping the matrix across its main diagonal:

1  2  3
  \ 
4  5  6
     \
7  8   9

The diagonal:
1
   5
      9
      
stays where it is, while the elements on opposite sides swap.
*/


public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {                            // becz we will play after diagonals
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }
    }
}

/*
So the correct transformations are:
90° clockwise
→ Transpose
→ Reverse every ROW

90° anticlockwise
→ Transpose
→ Reverse every COLUMN

See the difference clearly

Starting matrix:
1 2 3
4 5 6
7 8 9

After transpose:
1 4 7
2 5 8
3 6 9

→ Clockwise
Reverse rows:
7 4 1
8 5 2
9 6 3

→ Anticlockwise
Reverse columns:
3 6 9
2 5 8
1 4 7
*/
