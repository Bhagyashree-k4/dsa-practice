
package com.gs.dsa.students;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import java.util.*;
public class BestAveragePerStudentTest {
  @Test void validation(){ String[][] data={{"Alice","90"},{"Alice","-5"},{"Bob","70"},{"Bob","80"},{"Bob","oops"}}; Map<String,Double> m=BestAveragePerStudent.bestAverages(data); assertThat(m.get("Alice")).isEqualTo(90.0); assertThat(m.get("Bob")).isEqualTo(75.0); }
}
