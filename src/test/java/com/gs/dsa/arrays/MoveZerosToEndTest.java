
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class MoveZerosToEndTest {
  @Test void stableMove(){int[] a={1,2,0,4,0,7,0};MoveZerosToEnd.moveZeros(a);assertThat(a).containsExactly(1,2,4,7,0,0,0);} }
