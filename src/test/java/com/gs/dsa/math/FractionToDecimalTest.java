
package com.gs.dsa.math;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class FractionToDecimalTest {
  @Test void recurring(){ assertThat(FractionToDecimal.fractionToDecimal(10,3)).isEqualTo("3.(3)"); assertThat(FractionToDecimal.fractionToDecimal(1,2)).isEqualTo("0.5"); }
}
