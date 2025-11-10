
package com.gs.dsa.math;

/**
 * Compute dot product of two equal-length integer arrays.
 * Edge cases: null inputs, length mismatch, overflow awareness.
 */
public final class DotProduct {
    private DotProduct() {}
    /** TODO: Validate inputs and sum products. */
    public static long dot(int[] a, int[] b) {
        long result = 0;

        if(a.length != b.length) {
            return - 1;
        }

        for(int i = 0; i < a.length; i++) {

            result += a[i] * b[i];
        }
        return result;
    }
}
