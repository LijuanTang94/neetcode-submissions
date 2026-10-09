class Solution {
    List<String> res;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        dfs(n, 0, 0);
        return res;
    }

    private void dfs(int n, int l, int r) {
        if (l == n && l == r) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append("(");
            dfs(n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            dfs(n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
