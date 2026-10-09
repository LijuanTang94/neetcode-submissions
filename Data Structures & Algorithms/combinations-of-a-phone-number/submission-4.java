class Solution {
    List<String> res;
    StringBuilder sb;
    String[] words;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        sb = new StringBuilder();
        words = new String[10];
        words[2] = "abc";
        words[3] = "def";
        words[4] = "ghi";
        words[5] = "jkl";
        words[6] = "mno";
        words[7] = "pqrs";
        words[8] = "tuv";
        words[9] = "wxyz";
        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(idx) - '0';
        for(char a: words[num].toCharArray()) {
            sb.append(a);
            dfs(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
