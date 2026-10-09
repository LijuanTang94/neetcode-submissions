class Solution {
    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
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
            if (check(s, i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
