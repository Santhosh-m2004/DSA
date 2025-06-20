package matrix_java;
class wordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;  // Number of rows in the board
        int n = board[0].length;  // Number of columns in the board

        boolean[][] visited = new boolean[m][n]; // To track visited cells
        boolean res = false; // To store if the word is found

        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the first character of the word matches the board cell
                if (board[i][j] == word.charAt(0)) {
                    // Start backtracking to search for the word
                    res = backtrack(board, word, visited, i, j, 0);
                    
                    // If found, return true
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false; // If word is not found in any path
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // If the whole word is found, return true
        if (index == word.length()) {
            return true;
        }

        // Check if we are out of bounds, the cell is already visited, or the character does not match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Try moving in all four directions (down, up, right, left) to find the next character
        if (backtrack(board, word, visited, i + 1, j, index + 1) || // Move Down
            backtrack(board, word, visited, i - 1, j, index + 1) || // Move Up
            backtrack(board, word, visited, i, j + 1, index + 1) || // Move Right
            backtrack(board, word, visited, i, j - 1, index + 1)) { // Move Left
            return true; // If any direction finds the word, return true
        }

        // Backtrack: Unmark the cell before returning
        visited[i][j] = false;
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        wordSearch ws = new wordSearch();
        System.out.println(ws.exist(board, word));
    }
}
