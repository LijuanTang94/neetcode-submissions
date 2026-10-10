class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        q.offer(new int[]{i, j});
                        board[i][j] = 'T';
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] d: dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (board[x][y] == 'O') {
                    board[x][y] = 'T';
                    q.offer(new int[]{x, y});
                }
            }
        }
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    
}
