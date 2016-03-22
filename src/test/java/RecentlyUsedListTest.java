import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyUsedListTest {

    RUList list = new RUList(100);

    @Test
    public void newRUListIsEmpty() {
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void addItemAndGetIt() {
        addItems("hello");

        assertThat(list.get(0)).isEqualTo("hello");
    }

    @Test
    public void addTwoDifferentItemsAndGetThem() {
        addItems("one", "two");

        assertThat(list.get(0)).isEqualTo("two");
        assertThat(list.get(1)).isEqualTo("one");
    }

    @Test
    public void listOfUniqueItemsHasSize() {
        addItems("one", "two");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void addingAnItemAlreadyInTheListMovesItToTheFront() {
        addItems("one", "two", "one");

        assertListItems("one", "two");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void checkDuplicateInsertionWithAFewMoreItems() {
        addItems("a", "b", "c", "d", "e");
        addItems("c");

        assertListItems("c", "e", "d", "b", "a");
    }

    @Test
    public void capacityCanBeSpecified() {
        list = new RUList(3);
        addItems("a", "b", "c", "d");

        assertListItems("d", "c", "b");
    }


    private void assertListItems(String... items) {
        for (int i = 0; i < items.length; i++) {
            assertThat(list.get(i)).isEqualTo(items[i]);
        }
        assertThat(list.size()).isEqualTo(items.length);
    }

    private void addItems(String... items) {
        for (String item : items) {
            list.add(item);
        }
    }
}
