package com.gs.dsa.strings;

/**
 * "Given a dictionary (list of words) and a substring, you have to return the length of the longest word in the dictinary containing the substring.
 *
 * Example:
 * String[] dict = {""CODGE"", ""ODG"", ""LODGES"", ""SODG"", ""dodge"", ""mODJ"", ""LODGESSSS""}
 * String toSearch = ""ODG"";
 *
 * //Returns 9 (LODGESSSS)"
 */
public class WordContainingSubstringInDictionaryUsingTrie {
    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // Insert a string into the trie (lowercase manually)
        void insert(String s) {
            TrieNode node = root;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // lowercase conversion
                if (c >= 'A' && c <= 'Z') c = (char)(c + 32);

                int idx = c - 'a';

                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();

                node = node.children[idx];
            }
            node.isEnd = true;
        }

        // Check if trie contains a substring (manual search)
        boolean contains(String s) {
            TrieNode node = root;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c >= 'A' && c <= 'Z') c = (char)(c + 32);

                int idx = c - 'a';

                if (node.children[idx] == null) return false;

                node = node.children[idx];
            }
            return true;
        }
    }

    // Build suffix trie for a word
    static Trie buildSuffixTrie(String word) {
        Trie trie = new Trie();

        for (int i = 0; i < word.length(); i++) {
            trie.insert(word.substring(i));  // insert all suffixes
        }
        return trie;
    }

    // Main function
    public static int longestWordContaining(String[] dict, String toFind) {
        int maxLen = 0;

        for (String word : dict) {
            Trie trie = buildSuffixTrie(word);

            if (trie.contains(toFind)) {
                maxLen = Math.max(maxLen, word.length());
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge",
                "mODJ", "LODGESSSS"};

        String toSearch = "ODG";

        System.out.println(longestWordContaining(dict, toSearch)); // 9
    }
}
/**
 * ⭐ High-Level Idea (Easy to Remember)
 *
 * For each word:
 *
 * Build a suffix Trie
 *
 * Insert all suffixes of the word into the trie
 * (word[i…end] for every i)
 *
 * Search the substring in the trie
 *
 * If found → word contains this substring
 *
 * Keep track of the longest such word.
 *
 * ⭐ Pseudocode (Simple & Interview-Friendly)
 * Trie Node
 * class TrieNode:
 *     children[26]
 *
 * Build Suffix Trie for a Word
 * function buildSuffixTrie(word):
 *     trie = new Trie()
 *
 *     for i from 0 to word.length-1:
 *         suffix = word[i .. end]
 *         trie.insert(suffix)
 *
 *     return trie
 *
 * Insert into Trie
 * function insert(trie, text):
 *     node = trie.root
 *
 *     for each character c in text:
 *         convert c to lowercase manually
 *         index = c - 'a'
 *
 *         if node.children[index] is null:
 *             node.children[index] = new TrieNode()
 *
 *         node = node.children[index]
 *
 * Check if substring exists in Trie
 * function contains(trie, pattern):
 *     node = trie.root
 *
 *     for each character p in pattern:
 *         convert p to lowercase manually
 *         index = p - 'a'
 *
 *         if node.children[index] is null:
 *             return false
 *
 *         node = node.children[index]
 *
 *     return true
 *
 * ⭐ Main Logic
 * function longestWordContainingSubstring(dict, pattern):
 *     maxLen = 0
 *
 *     for each word in dict:
 *
 *         trie = buildSuffixTrie(word)
 *
 *         if contains(trie, pattern):
 *             maxLen = max(maxLen, word.length)
 *
 *     return maxLen
 *
 * ⭐ Complexity (Easy Explanation)
 *
 * Build suffix trie for a word of length N:
 * inserts N suffixes → O(N²)
 *
 * Searching substring: O(M)
 *
 * Used only because the question said “Trie logic”.
 */
