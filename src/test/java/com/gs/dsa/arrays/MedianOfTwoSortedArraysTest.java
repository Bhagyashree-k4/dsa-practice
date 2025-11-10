
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import com.gs.dsa.util.ComplexityGate;
public class MedianOfTwoSortedArraysTest {
  @Test void examples(){
    assertThat(MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2})).isEqualTo(2.0);
    assertThat(MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4})).isEqualTo(2.5);
  }
  @Test void logNGate(){
    ComplexityGate.assertComplexity(ComplexityGate.Expectation.LOG_N,
      n -> {int m=Math.max(1,n/2);int[] a=new int[m];int[] b=new int[n];int x=-n;for(int i=0;i<m;i++){a[i]=x;x+=2;}for(int i=0;i<n;i++){b[i]=x;x+=2;}return new Object[]{a,b};},
      in -> MedianOfTwoSortedArrays.findMedianSortedArrays((int[])((Object[])in)[0],(int[])((Object[])in)[1]),
      10_000,2);
  }
}
