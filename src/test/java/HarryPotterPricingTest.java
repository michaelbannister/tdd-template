import domain.Book;
import domain.BookPriceCalculator;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static domain.Book.*;

public class HarryPotterPricingTest {

    @Test
    public void oneCopyHasNoDiscount() {
        assertThat(priceOf(BOOK_ONE)).isEqualTo(Book.STANDARD_PRICE);
    }

    @Test
    public void multipleCopiesOfTheSameBookHaveNoDiscount() {
        assertThat(priceOf(BOOK_ONE, BOOK_ONE)).isEqualTo(Book.STANDARD_PRICE * 2);
    }

    @Test
    public void twoDifferentBooksGetFivePercentDiscount() {
        assertThat(priceOf(BOOK_ONE, BOOK_TWO)).isEqualTo(fivePercentDiscount(Book.STANDARD_PRICE * 2));
    }

    @Test
    public void threeDifferentBooksGetFivePercentDiscount() {
        assertThat(priceOf(BOOK_ONE, BOOK_TWO, BOOK_THREE)).isEqualTo(tenPercentDiscount(Book.STANDARD_PRICE * 3));
    }


    private double fivePercentDiscount(int price) {
        return price * 0.95d;
    }

    private double tenPercentDiscount(long price) {
        return price * 0.9d;
    }

    private double priceOf(Book... books) {
        return new BookPriceCalculator().priceOf(books);
    }
}
