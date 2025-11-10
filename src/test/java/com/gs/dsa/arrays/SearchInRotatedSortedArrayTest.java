
package com.gs.dsa.arrays;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import com.gs.dsa.util.ComplexityGate;
public class SearchInRotatedSortedArrayTest {
  @Test void typical(){
    assertThat(SearchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2},0)).isEqualTo(4);
    assertThat(SearchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2},3)).isEqualTo(-1);
  }
  @Test void hardCasesMerged(){
    assertThat(SearchInRotatedSortedArray.search(new int[]{6,7,8,1,2,3,4,5},8)).isEqualTo(2);
    assertThat(SearchInRotatedSortedArray.search(new int[]{1},0)).isEqualTo(-1);
    assertThat(SearchInRotatedSortedArray.search(new int[]{2,2,2,3,4,2},3)).isEqualTo(3);
  }
  @Test void logNGate(){
    ComplexityGate.assertComplexity(ComplexityGate.Expectation.LOG_N,
      n -> {int[] base=new int[n];for(int i=0;i<n;i++)base[i]=i*2;int rot=n/3;int[] arr=new int[n];for(int i=0;i<n;i++)arr[i]=base[(i+rot)%n];int[] targets=new int[]{arr[0],arr[n/8],arr[n/4],arr[n/2],arr[(3*n)/4],arr[n-1],-1};return new Object[]{arr,targets};},
      in -> {int[] arr=(int[])((Object[])in)[0];int[] t=(int[])((Object[])in)[1];int s=0;for(int x:t) s+=SearchInRotatedSortedArray.search(arr,x);return s;},
      100_000,3);
  }
}
