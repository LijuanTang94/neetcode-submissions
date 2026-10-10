class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] p: prerequisites) {
            int from = p[1], to = p[0];
            graph.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for(int nxt: graph.get(cur)) {
                if (--indegree[nxt] == 0) q.offer(nxt);
            }
        }
        if (res.size() != numCourses) return new int[]{};
        int[] arr = new int[numCourses];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
