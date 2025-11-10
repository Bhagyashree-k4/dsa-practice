
package com.gs.dsa.strings;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import com.gs.dsa.util.ComplexityGate;import java.util.Random;
public class LongestSubstringDistinctCharsTest {
  @Test void examples(){
    assertThat(LongestSubstringDistinctChars.lengthOfLongestDistinct("abcabcbb")).isEqualTo(3);
    assertThat(LongestSubstringDistinctChars.lengthOfLongestDistinct("bbbbb")).isEqualTo(1);
    assertThat(LongestSubstringDistinctChars.lengthOfLongestDistinct("pwwkew")).isEqualTo(3);
    assertThat(LongestSubstringDistinctChars.lengthOfLongestDistinct("abcdacmn")).isEqualTo(5);
  }
  @Test void linearGate(){
    Random rnd=new Random(123);
    ComplexityGate.assertComplexity(ComplexityGate.Expectation.LINEAR,
      n -> {StringBuilder sb=new StringBuilder(n);for(int i=0;i<n;i++) sb.append((char)('a'+rnd.nextInt(26)));return sb.toString();},
      in -> LongestSubstringDistinctChars.lengthOfLongestDistinct((String)in),
      200_000,2);
  }
}
