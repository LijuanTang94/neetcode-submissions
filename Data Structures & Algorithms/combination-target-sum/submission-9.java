class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0, target);
        return res;
    }

    private void dfs(int[] nums, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
