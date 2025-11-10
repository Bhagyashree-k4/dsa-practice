
package com.gs.dsa.strings;

/**
 * Minimum number of words in-between two target words (nearest occurrence).
 * Edge cases: targets missing, multiple occurrences, adjacency, same word twice.
 */
public final class MinWordDistance {
    private MinWordDistance() {}
    /** TODO: Track last indices of each word and compute in-between distance. */
    public static int minDistance(String[] words, String w1, String w2) {

        int index1 = -1, index2 = -1;
        int minResult = Integer.MAX_VALUE;

        for(int i=0; i< words.length ; i++){
            if(words[i].equalsIgnoreCase(w1)){
                index1 = i;
            }
            if(words[i].equalsIgnoreCase(w2)){
                index2 = i;
            }
            if(index1 != -1 && index2 !=-1)
                minResult = Math.min(minResult,Math.abs(index1-index2)-1);

        }

        return minResult;
    }
}
