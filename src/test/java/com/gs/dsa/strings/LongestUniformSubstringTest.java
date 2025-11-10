
package com.gs.dsa.strings;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class LongestUniformSubstringTest {
  @Test void example(){ assertThat(LongestUniformSubstring.longestUniform("aabbbbCCddd")).containsExactly(2,4); }
}
