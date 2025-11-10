
package com.gs.dsa.backtracking;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import java.util.List;
public class CombinationSumTest {
  @Test void sample(){ assertThat(CombinationSum.combinationSum(new int[]{2,3,6,7},7)).contains(List.of(7)); }
}
