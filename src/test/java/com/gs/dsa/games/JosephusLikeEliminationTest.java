
package com.gs.dsa.games;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class JosephusLikeEliminationTest {
  @Test void sample(){ assertThat(JosephusLikeElimination.elect(4,2)).isEqualTo(1); }
}
