
package com.gs.dsa.strings;

/**
 * Longest run of same character; return [start, length].
 * Edge cases: empty string, all same char, ties (choose earliest start).
 */
public final class LongestUniformSubstring {
    private LongestUniformSubstring() {}
    /** TODO: Implement linear scan of runs. */
    public static int[] longestUniform(String s) {
        int start = 0, count = 1;
        int maxCount = Integer.MIN_VALUE, resultIndex = -1;
        char current = s.charAt(start);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==current)
                count++;
            else{
                if(count >= maxCount){
                    maxCount = count;
                    resultIndex = i-count;
                }
                current = s.charAt(i);
                count = 1;
            }
        }
        if(count>=maxCount){
            maxCount = count;
            resultIndex = s.length() - count;
        }

        return new int[]{resultIndex,maxCount};
    }
}
