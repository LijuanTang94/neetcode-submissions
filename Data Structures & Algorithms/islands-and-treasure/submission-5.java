class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] d: dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (grid[x][y] == -1) continue;
                    if (depth < grid[x][y]) {
                        grid[x][y] = depth;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
