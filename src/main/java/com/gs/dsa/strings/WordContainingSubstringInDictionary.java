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
public class WordContainingSubstringInDictionary {
    public static int longestWordContaining(String[] dict, String toSearch) {
        if (dict == null || toSearch == null) return 0;

        String target = toSearch.toLowerCase();
        int maxLen = 0;

        for (String word : dict) {
            if (word.toLowerCase().contains(target)) {
                maxLen = Math.max(maxLen, word.length());
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG",
                "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG";

        System.out.println(longestWordContaining(dict, toSearch)); // 9
    }
}
