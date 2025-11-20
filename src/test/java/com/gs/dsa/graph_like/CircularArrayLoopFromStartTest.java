
package com.gs.dsa.graph_like;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class CircularArrayLoopFromStartTest {
  @Test void simple(){ assertThat(CircularArrayLoopFromStart.circularArrayLoop(new int[]{2,-1,1,2,2},0)).isGreaterThanOrEqualTo(0); }
}
