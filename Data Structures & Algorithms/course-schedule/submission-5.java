class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courses = 0;
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
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            courses++;
            for(int nxt: graph.get(cur)) {
                if (--indegree[nxt] == 0) q.offer(nxt);
            }
        }
        return courses == numCourses ? true : false;
    }
}
