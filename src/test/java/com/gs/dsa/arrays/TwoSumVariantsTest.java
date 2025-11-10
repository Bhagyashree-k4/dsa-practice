
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import com.gs.dsa.util.ComplexityGate;import java.util.Random;
public class TwoSumVariantsTest {
  @Test void correctness(){
    assertThat(TwoSumVariants.twoSumFirst(new int[]{2,7,11,15},9)).containsExactly(0,1);
    assertThat(TwoSumVariants.twoSumSmallestIndices(new int[]{3,2,4,3},6)).containsExactly(0,3);
    assertThat(TwoSumVariants.twoSumLargestIndices(new int[]{1,5,3,3,4,2,4},7)).containsExactly(3,6);
  }
  @Test void linearGate(){
    Random rnd=new Random(99);
    ComplexityGate.assertComplexity(ComplexityGate.Expectation.LINEAR,
      n -> {int[] a=new int[n];for(int i=0;i<n;i++)a[i]=rnd.nextInt(1000);return new Object[]{a,1000};},
      in -> TwoSumVariants.twoSumFirst((int[])((Object[])in)[0], (Integer)((Object[])in)[1]),
      200_000,2);
  }
}
