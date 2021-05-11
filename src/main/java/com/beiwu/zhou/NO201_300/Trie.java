package com.beiwu.zhou.NO201_300;

class Trie {
    TrieNode head;

    class TrieNode {
        final int LENGTH = 26;
        TrieNode[] nodes;
        boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[LENGTH];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode next = cur.nodes[ch - 'a'];
            if (next == null) {
                next = new TrieNode();
            }
            cur.nodes[ch - 'a'] = next;
            cur = next;
        }
        cur.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode next = cur.nodes[ch - 'a'];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        if (cur != null && cur.isEnd) {
            return true;
        }

        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = head;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode next = cur.nodes[ch - 'a'];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        if (cur != null) {
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
