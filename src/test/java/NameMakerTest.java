import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameMakerTest {
    @Test
    public void shouldGroupByVolume() throws Exception {
        Pair resultPair = NameMaker.groupByVolume("Amy", "BRIAN", "Charlotte");

        assertThat(resultPair.getSaidNames()).containsExactly("Amy", "Charlotte");
        assertThat(resultPair.getShoutedNames()).containsExactly("BRIAN");
    }

}