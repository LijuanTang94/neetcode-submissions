class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j]) return false;
        if (word.charAt(start) == board[i][j]) {
            visited[i][j] = true;
            for(int[] d: dirs) {
                int x = i + d[0];
                int y = j + d[1];
                if (dfs(board, x, y, word, start + 1)) return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
