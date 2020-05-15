package com.cayro;

import java.util.Objects;

public class Trie {

    Trie[] letters = new Trie[26];
    boolean isWord;

    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie crawler = this;
        for (int i : word.toCharArray()) {
            if (Objects.isNull(crawler.letters[i - 97])) {
                Trie trie = new Trie();
                crawler.letters[i - 97] = trie;
                crawler = trie;
            } else {
                crawler = crawler.letters[i - 97];
            }
        }
        crawler.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie crawler = this;
        for (int i : word.toCharArray()) {
            if (Objects.isNull(crawler.letters[i - 97])) {
                return false;
            }
            crawler = crawler.letters[i - 97];
        }
        return crawler.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie crawler = this;
        for (int i : prefix.toCharArray()) {
            if (crawler.letters[i - 97] == null) {
                return false;
            }
            crawler = crawler.letters[i - 97];
        }
        return true;
    }
}
