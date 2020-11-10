package com.chen.algorithm.znn.frequency.test208;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shu-ju-jie-gou-she-ji-zhi-shi-xian-trie-qian-zhui-/
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 14:46
 * @Description: 实现 Trie (前缀树)
 */
public class Trie {

    public Trie root;
    public char val;
    public Trie[] children = new Trie[26];
    public boolean isWord;

    public Trie() {
        root = new Trie(' ');
    }

    public Trie(char val) {
        this.val = val;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new Trie(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
