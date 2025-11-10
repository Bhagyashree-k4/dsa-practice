
package com.gs.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Index of first non-repeating character. Edge cases: empty, all repeating, Unicode.
 */
public final class FirstNonRepeatingChar {
    private FirstNonRepeatingChar() {}
    /** TODO: Implement frequency counting then single pass. */
    public static int indexOfFirstUnique(String s) {
        char[] charArray = s.toCharArray();
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i= 0; i< charArray.length ; i++){
            freqMap.put(charArray[i], freqMap.getOrDefault(charArray[i],0) + 1);
        }
        for(int i=0; i< charArray.length;i++){
            if(freqMap.get(charArray[i]) == 1)
                return i;
        }
        return -1;
    }
}
