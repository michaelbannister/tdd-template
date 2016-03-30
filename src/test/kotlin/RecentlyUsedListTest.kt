
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RecentlyUsedListTest {

    @Test fun emptyListHasSizeZero() {
        assertThat(RecentlyUsedList().size).isEqualTo(0)
    }

    private val ABC = ruList("A", "B", "C")

    @Test fun addingDistinctItemsToListIncreasesSize() {
        assertThat(ABC.size).isEqualTo(3)
    }

    @Test fun getMostRecentlyAddedItem() {
        assertThat(ABC.get(0)).isEqualTo("C")
    }

    @Test fun getPreviouslyAddedItem() {
        assertThat(ABC.get(2)).isEqualTo("A")
    }

    @Test fun addingDuplicateDoesNotIncreaseSize() {
        ABC.add("B")
        assertThat(ABC.size).isEqualTo(3)
    }

    @Test fun addingDuplicateBringsItemToTheFront() {
        ABC.add("B")
        assertThat(ABC.get(0)).isEqualTo("B")
    }

    @Test fun addingDuplicateWorksWithSingleItem() {
        val list = ruList("B", "B")
        assertThat(list.size).isEqualTo(1)
    }

    fun ruList(vararg items: String): RecentlyUsedList {
        val list = RecentlyUsedList()
        items.forEach {
            list.add(it)
        }
        return list
    }
}

