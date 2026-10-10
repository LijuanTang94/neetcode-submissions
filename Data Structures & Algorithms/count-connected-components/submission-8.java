class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;
        for(int nxt: graph.get(start)) {
            if (!visited[nxt]) {
                dfs(graph, nxt, visited);
            }
        }
    }
}
