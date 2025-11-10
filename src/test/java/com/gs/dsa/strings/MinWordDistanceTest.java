
package com.gs.dsa.strings;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class MinWordDistanceTest {
  @Test void sentence(){ String[] words="the quick the brown quick brown the frog".split(" "); assertThat(MinWordDistance.minDistance(words,"quick","frog")).isEqualTo(2); }
}
