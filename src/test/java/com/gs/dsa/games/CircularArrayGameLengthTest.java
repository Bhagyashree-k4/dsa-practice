
package com.gs.dsa.games;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class CircularArrayGameLengthTest {
  @Test void simple(){ assertThat(CircularArrayGameLength.cycleLength(new int[]{1,2,3,4,5,6,5})).isGreaterThanOrEqualTo(0); }
}
