
package com.gs.dsa.strings;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class FirstNonRepeatingCharTest {
  @Test void basic(){
    assertThat(FirstNonRepeatingChar.indexOfFirstUnique("leetcode")).isEqualTo(0);
    assertThat(FirstNonRepeatingChar.indexOfFirstUnique("aabb")).isEqualTo(-1);
  }
}
