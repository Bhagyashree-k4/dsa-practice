
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class SecondSmallestInArrayTest {
  @Test void basic(){ assertThat(SecondSmallestInArray.secondSmallest(new int[]{5,1,2,1,3})).isEqualTo(2); }
}
