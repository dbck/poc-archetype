package ${package};


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
class SimpleTestIT {

  @Test
  void oneIsOneIT() throws Exception {
    assertThat(1).isEqualTo(1);
  }
}
