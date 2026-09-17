/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/

public class WordSearch {
    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
    
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(0, i, j, board, word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int pos, int row, int col, char[][] board, String word) {
      
         // Whole word has been matched
        if (pos == word.length()) {
            return true;
        }

        // Outside the board
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        // Current cell doesn't match
        if (board[row][col] != word.charAt(pos)) {
            return false;
        }

        // Mark current cell as visited
        char original = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found =
                dfs(pos + 1, row - 1, col, board, word) ||
                dfs(pos + 1, row + 1, col, board, word) ||
                dfs(pos + 1, row, col - 1, board, word) ||
                dfs(pos + 1, row, col + 1, board, word);

        // Backtrack: restore original character
        board[row][col] = original;

        return found;
    }
}


/*
The main reason is that Java String is immutable.

When we write: currentString + board[row][col]
Java cannot modify currentString itself. It has to create a new String object containing the old characters plus the new character.

Example
currentString = "ABC";

Then:
currentString + 'D'

creates:
"ABC"  →  "ABCD"
The original "ABC" doesn't change.

In our DFS, this happens at every recursive call:
"A"
"AB"
"ABC"
"ABCC"
"ABCCD"
...
So you're repeatedly creating new objects and copying characters.

If the current string has length k, creating the next string involves roughly O(k) work.
And .equals()?

We were doing: if (currentString.equals(word))
String.equals() has to check whether the strings have the same contents.

For example:
currentString = "ABCCD"
word         = "ABCCD"

Java may have to compare:
A == A
B == B
C == C
C == C
D == D
So in the worst case, that's O(k) where k is the string length.
And we're doing this at every DFS call.


Another optimization is creating and using a boolean matrix for checking visited block.

char temp = board[row][col];
board[row][col] = '#';

Instead of:  visited[row][col] = true;

And after exploring:  board[row][col] = temp;

Instead of:  visited[row][col] = false;

So the backtracking is still exactly:
mark
  ↓
explore
  ↓
restore
Wr're just storing the visited state inside the board itself, so we don't need a separate boolean[][].
*/
 class WordSearchNotOptimzed {
    private int rows, cols;
    private boolean found;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
    
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(word.charAt(0) == board[i][j] && visited[i][j] != true) {
                        if(("" + board[i][j]).equals(word)) return true;

                    dfs("", 0, i, j, board, visited, word);
                    if(found) return true;
                }
            }
        }
        return found;
    }

    private void dfs(String currentString, int pos, int row, int col, char[][] board, boolean[][] visited, String word) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;
        if(currentString.equals(word)) {
            found = true;
            return;
        }

        if(visited[row][col]) return;
        if(board[row][col] != word.charAt(pos)) return;

        visited[row][col] = true;

        dfs(currentString + board[row][col], pos + 1, row - 1, col, board, visited, word);
        dfs(currentString + board[row][col], pos + 1, row + 1, col, board, visited, word);
        dfs(currentString + board[row][col], pos + 1, row, col - 1, board, visited, word);
        dfs(currentString + board[row][col], pos + 1, row, col + 1, board, visited, word);

        visited[row][col] = false;
    }
}
