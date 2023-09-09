package com.vuluong.leetcode;

import java.util.*;

public class GuessTheWord {

    interface Master {
        int guess(String word);
    }

    public static class DefaultMaster implements Master {

        int count;

        public DefaultMaster() {
            count = 0;
        }

        @Override
        public int guess(String word) {
            count += 1;
            return new Solution().matches(word, "azzzzz");
        }
    }

    public static class Solution {

        private int matches(String w1, String w2) {
            int dist = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) == w2.charAt(i)) {
                    dist += 1;
                }
            }
            return dist;
        }

        public void findSecretWord(String[] words, Master master) {
            int nWords = words.length;
            Set<Integer>[][] adj = new HashSet[nWords][7];
            int start = -1;
            int maxMatches = -1;
            for (int i = 0; i < nWords; i++) {
                for (int j = i + 1; j < nWords; j++) {
                    int matches = matches(words[i], words[j]);
                    if (matches > maxMatches) {
                        start = i;
                        maxMatches = matches;
                    }
                    
                    if (adj[i][matches] == null) {
                        adj[i][matches] = new HashSet<>();
                    }
                    adj[i][matches].add(j);

                    if (adj[j][matches] == null) {
                        adj[j][matches] = new HashSet<>();
                    }
                    adj[j][matches].add(i);
                }
            }

            Random random = new Random();
            int guess = start;
            boolean[] visited = new boolean[nWords];
            Set<Integer> set = null;

            while (true) {
                int matches = master.guess(words[guess]);
                visited[guess] = true;
                if (matches == 6) {
                    return;
                }
                if (set == null) {
                    set = new HashSet<>(adj[guess][matches]);
                }
                
                Iterator<Integer> it = set.iterator();
                List<Integer> cands = new ArrayList<>();
                while (it.hasNext()) {
                    int next = it.next();
                    if (!adj[guess][matches].contains(next) || visited[next]) {
                        it.remove();
                    } else {
                        cands.add(next);
                    }
                }
                guess = cands.get(random.nextInt(cands.size()));
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        DefaultMaster master = new DefaultMaster();
        sol.findSecretWord(
            new String[]{"abcdef","acdefg","adefgh","aefghi","afghij","aghijk","ahijkl","aijklm","ajklmn","aklmno","almnoz","anopqr","azzzzz"},
            master
        );
        System.out.println(master.count);
    }
}
