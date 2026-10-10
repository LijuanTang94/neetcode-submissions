class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs ={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] d: dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            minutes++;
        }
        return fresh != 0 ? -1 : minutes - 1;
    }
}
