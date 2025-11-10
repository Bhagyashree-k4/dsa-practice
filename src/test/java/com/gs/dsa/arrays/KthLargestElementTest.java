
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class KthLargestElementTest {
  @Test void examples(){
    assertThat(KthLargestElement.kthLargest(new int[]{3,2,1,5,6,4},2)).isEqualTo(5);
    assertThat(KthLargestElement.kthLargest(new int[]{3,2,3,1,2,4,5,5,6},4)).isEqualTo(4);
  }
}
