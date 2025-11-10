
package com.gs.dsa.ds;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;
public class QueueUsingStacksTest {
  @Test void basicOps(){ QueueUsingStacks.MyQueue q=new QueueUsingStacks.MyQueue(); q.push(1); q.push(2); q.push(3); assertThat(q.peek()).isEqualTo(1); assertThat(q.pop()).isEqualTo(1); assertThat(q.pop()).isEqualTo(2); assertThat(q.peek()).isEqualTo(3); assertThat(q.pop()).isEqualTo(3); assertThat(q.empty()).isTrue(); }
}
