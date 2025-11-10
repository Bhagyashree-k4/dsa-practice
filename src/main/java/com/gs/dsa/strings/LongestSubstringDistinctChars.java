
package com.gs.dsa.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Length of longest substring with all distinct characters (sliding window).
 * Edge cases: empty, repeated clusters, large alphabets.
 */
public final class LongestSubstringDistinctChars {
    private LongestSubstringDistinctChars() {}
    /** TODO: Implement O(n) sliding window with last-seen positions. */
    public static int lengthOfLongestDistinct(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int maxLen = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while(window.contains(c)) {
                window.remove(s.charAt(left++));
            }

            window.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
