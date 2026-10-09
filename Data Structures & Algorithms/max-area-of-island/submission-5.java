class Solution {
    int max = 0;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int count = 1;
        for(int[] d: dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) continue;
            count += dfs(grid, x, y);
        }
        return count;
    }
}
