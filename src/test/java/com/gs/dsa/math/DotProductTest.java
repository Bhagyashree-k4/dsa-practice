
package com.gs.dsa.math;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class DotProductTest {
  @Test void basic(){ assertThat(DotProduct.dot(new int[]{1,2,3}, new int[]{4,5,6})).isEqualTo(32); }
}
