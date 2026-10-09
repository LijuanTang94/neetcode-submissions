class Solution {
    List<List<String>> res;
    List<String> path;
    boolean[][] check;
    public List<List<String>> partition(String s) {
        check = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || check[i + 1][j - 1])) {
                    check[i][j] = true;
                }
            }
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if (check[i][j]) {
                path.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    
}
