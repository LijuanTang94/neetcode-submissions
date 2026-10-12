class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Union u = new Union(edges.length + 1);
        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];
            if (!u.union(from, to)) return edge;
        }
        return new int[2];
    }
    class Union{
        int count;
        int[] parent;
        public Union(int n) {
            this.count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        private boolean union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return false;
            parent[pRoot] = qRoot;
            count--;
            return true;
        }
    }
}
