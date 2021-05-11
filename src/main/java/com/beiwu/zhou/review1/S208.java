package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-05-10 18:27
 */
public class S208 {

    class Trie {
        Trie[] children;
        private boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie cur = this;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }

            cur.isEnd = true;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie cur = this;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            if (cur.isEnd) {
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            int length = prefix.length();
            for (int i = 0; i < length; i++) {
                char ch = prefix.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            return true;
        }
    }

}
