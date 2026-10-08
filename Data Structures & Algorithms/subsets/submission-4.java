class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[start]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
