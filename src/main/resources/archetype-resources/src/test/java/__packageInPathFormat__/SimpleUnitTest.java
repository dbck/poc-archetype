package ${package};


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleUnitTest {

  @Test
  void oneIsOne() throws Exception {
    assertThat(1).isEqualTo(1);
  }

  @Test
  void twoIsTwo() throws Exception {
    assertThat(2).isEqualTo(2);
  }
  
  @Test
  void twoIsThree() throws Exception {
    assertThat(3).isEqualTo(3);
  }
}
