class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
