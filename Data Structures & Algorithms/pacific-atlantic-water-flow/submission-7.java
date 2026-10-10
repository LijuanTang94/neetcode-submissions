class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacs = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            q.offer(new int[] {i, 0});
            pacs[i][0] = true;
        }
        for(int j = 1; j < n; j++) {
            q.offer(new int[]{0, j});
            pacs[0][j] = true;
        }
        dfs(heights, q, pacs);
        boolean[][] atls = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            q.offer(new int[] {i, n - 1});
            atls[i][n - 1] = true;
        }
        for(int j = 0; j < n - 1; j++) {
            q.offer(new int[] {m - 1, j});
            atls[m - 1][j] = true;
        }
        dfs(heights, q, atls);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (pacs[i][j] && atls[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, Queue<int[]> q, boolean[][] arr) {
        int m = heights.length;
        int n = heights[0].length;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] d: dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (arr[x][y]) continue;
                    if (heights[x][y] >= heights[cur[0]][cur[1]]) {
                        q.offer(new int[]{x, y});
                        arr[x][y] = true;
                    }
                }
            }
        }
    }
}
