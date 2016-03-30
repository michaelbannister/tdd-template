
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class ConsListTest {
    private val ABC = consListOf("A", "B", "C")

    @Test fun nilListHasSizeZero() {
        assertThat(Nil.size).isEqualTo(0)
    }

    @Test fun nonEmptyListHasCorrectSize() {
        assertThat(ABC.size).isEqualTo(3)
    }

    @Test fun getItemAtIndex() {
        assertThat(ABC.get(0)).isEqualTo("A")
        assertThat(ABC.get(2)).isEqualTo("C")
    }

    @Test fun getItemAtInvalidIndexThrowsException() {
        assertThatThrownBy { ABC.get(4) }.isInstanceOf(IndexOutOfBoundsException::class.java)
    }

    @Test fun canIdentifyWhetherListContainsAnItem() {
        assertThat(ABC.contains("B")).isTrue()
        assertThat(ABC.contains("D")).isFalse()
    }

    @Test fun canObtainSubListUpToEndOfList() {
        assertThat(ABC.subList(2, 3)).isEqualTo(consListOf("C"))
        assertThat(ABC.subList(0, 3)).isEqualTo(ABC)
    }

    @Test fun canObtainSubListNotIncludingEnd() {
        assertThat(ABC.subList(0, 2)).isEqualTo(consListOf("A", "B"))
        assertThat(ABC.subList(1, 2)).isEqualTo(consListOf("B"))
    }

    @Test fun canConcatenateLists() {
        assertThat(consListOf("A", "B", "C") + consListOf("D", "E", "F")).isEqualTo(consListOf("A", "B", "C", "D", "E", "F"))
    }

}