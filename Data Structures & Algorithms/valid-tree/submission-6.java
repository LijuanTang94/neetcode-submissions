class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
        if (dfs(graph, 0, -1, visited)) return false;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int start, int parent, boolean[] visited) {
        if (visited[start]) return true;
        visited[start] = true;
        for(int nxt: graph.get(start)) {
            if (nxt == parent) continue;
            if (dfs(graph, nxt, start, visited)) return true;
        }
        return false;
    }
}
