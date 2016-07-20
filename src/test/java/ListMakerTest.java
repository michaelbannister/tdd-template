import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListMakerTest {

    @Test
    public void shouldUseAndToSeparateTwoWords() {
        assertThat(ListMaker.withOxfordComma("A", "B")).isEqualTo("A and B");
    }

    @Test
    public void shouldUseOxfordCommaForMoreThanTwoWords() {
        assertThat(ListMaker.withOxfordComma("A", "B", "C")).isEqualTo("A, B, and C");
    }
}
