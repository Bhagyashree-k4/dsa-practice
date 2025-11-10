
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import com.gs.dsa.util.ComplexityGate;import java.util.Random;
public class TrappingRainwaterTest {
  @Test void sample(){
    assertThat(TrappingRainwater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})).isEqualTo(6);
  }
  @Test void linearGate(){
    Random rnd=new Random(1);
    ComplexityGate.assertComplexity(ComplexityGate.Expectation.LINEAR,
      n -> {int[] h=new int[n];for(int i=0;i<n;i++)h[i]=rnd.nextInt(1000);return h;},
      in -> TrappingRainwater.trap((int[])in),
      200_000,2);
  }
}
