
package com.gs.dsa.math;

import java.util.HashMap;

/**
 * Convert fraction to decimal; enclose repeating part in parentheses.
 * Edge cases: sign handling, long division remainder cycles, denominator=0.
 */
public final class FractionToDecimal {
    private FractionToDecimal() {}
    /** TODO: Implement long division with remainder-position map. */
    public static String fractionToDecimal(long numerator, long denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if (numerator < 0 || denominator < 0) {
            result.append("-");
        }

        result.append(numerator / denominator);
        long remainder = numerator % denominator;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {

            if (remainderMap.containsKey(remainder)) {
                int repeatIndex = remainderMap.get(remainder);
                result.insert(repeatIndex, "(");
                result.append(")");
                return result.toString();
            }

            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / denominator);
            remainder %= denominator;
        }

        return result.toString();


    }
}
