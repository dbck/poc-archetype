package ${package};


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
class SimpleTestMockIT {

  @Test
  void oneIsOneMockIT() throws Exception {
    assertThat(Integer.parseInt("1")).isEqualTo(1);
  }
}