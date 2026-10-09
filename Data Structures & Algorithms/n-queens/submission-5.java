class Solution {
    List<List<String>> res;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0);
        return res;
    }

    private void dfs(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            List<String> path = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                path.add(sb.toString());
            }
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int j = 0; j < n; j++) {
            if (check(board, row, j)) {
                board[row][j] = 'Q';
                dfs(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    private boolean check(char[][] board, int row, int col) {
        int n = board.length;
        for(int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
