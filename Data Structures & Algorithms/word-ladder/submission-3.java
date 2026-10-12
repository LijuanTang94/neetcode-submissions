class Solution {
    Set<String> dicts;
    int len = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dicts = new HashSet<>();
        for(String word: wordList) {
            dicts.add(word);
        }
        if (!dicts.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();
                for(int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for(char a = 'a'; a <= 'z'; a++) {
                        arr[j] = a;
                        String nxt = new String(arr);
                        if (!dicts.contains(nxt)) continue;
                        if (nxt.equals(endWord)) {
                            return step + 1;
                        }
                        dicts.remove(nxt);
                        q.offer(nxt);
                    }
                    arr[j] = old;
                }
            }
            step++;
        }
        return 0;
    }

   
}
