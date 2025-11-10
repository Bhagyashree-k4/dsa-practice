
package com.gs.dsa.matrix;

import java.util.*;

/**
 * Return spiral order traversal of an m x n matrix.
 * Edge cases: 1xN, Nx1, empty, non-rectangular assumptions.
 */
public final class SpiralMatrix {
    private SpiralMatrix() {}
    /** TODO: Implement layer-by-layer traversal. */
    public static List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> result = new ArrayList<>();

       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return result;
       }

       int top = 0, left = 0;
       int right = matrix[0].length - 1;
       int bottom = matrix.length - 1;

       while (top <= bottom && left <= right) {
           //Traverse left to right
           for(int j = left; j <= right; j++) {
               result.add(matrix[top][j]);
           }
           top++;

           //Traverse top to bottom
           for(int i = top; i <= bottom; i++) {
               result.add(matrix[i][right]);
           }
           right--;

           //Traverse right to left
           if(left <= right) {
               for(int j = right; j >= left; j--) {
                   result.add(matrix[bottom][j]);
               }
               bottom--;
           }

           //Traverse bottom to top
           if(top <= bottom) {
               for(int i = bottom; i >= top; i--) {
                   result.add(matrix[i][left]);
               }
               left++;
           }
       }
           return result;
    }
}
