
package com.gs.dsa.graph_like;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class UniquePathsGridTest {
  @Test void small(){ assertThat(UniquePathsGrid.uniquePaths(3,7)).isEqualTo(28); }
}
