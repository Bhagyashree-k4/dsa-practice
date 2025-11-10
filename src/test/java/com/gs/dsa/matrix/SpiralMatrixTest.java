
package com.gs.dsa.matrix;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import java.util.List;
public class SpiralMatrixTest {
  @Test void square3(){ int[][] m={{1,2,3},{4,5,6},{7,8,9}}; assertThat(SpiralMatrix.spiralOrder(m)).isEqualTo(List.of(1,2,3,6,9,8,7,4,5)); }
}
