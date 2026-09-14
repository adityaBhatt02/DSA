public class SurroundedRegion {
    private int rows, cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // top row
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') dfs(0, i, board);
        }

        // bottom row
        for(int i = 0; i < cols; i++) {
            if(board[rows - 1][i] == 'O') dfs(rows - 1, i, board);
        }

        // left boundary
        for(int i = 1; i < rows - 1; i++) {                       // you can start from i = 0 but its already been processed by when checking for top row and end it at row - 1 but why do it if bottom row check already processed that particular block.
            if(board[i][0] == 'O') dfs(i, 0, board);
        }

        // right boundary
        for(int i = 1; i < rows - 1; i++) {                      // you can start from i = 0 but its already been processed by when checking for top row and end it at row - 1 but why do it if bottom row check already processed that particular block.
            if(board[i][cols - 1] == 'O') dfs(i, cols - 1, board);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;
        if(board[row][col] != 'O') return;

        board[row][col] = '#';
        dfs(row - 1, col, board);
        dfs(row + 1, col, board);
        dfs(row, col - 1, board);
        dfs(row, col + 1, board);
    }
}