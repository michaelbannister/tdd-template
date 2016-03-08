package domain;

import java.util.Arrays;

public class BookPriceCalculator {
    public double priceOf(Book... books) {

        int uniqueTitles = (int) Arrays.stream(books).distinct().count();

        switch (uniqueTitles) {
            case 3:
                return threeBookDiscount(Book.STANDARD_PRICE * books.length);
            case 2:
                return twoBookDiscount(Book.STANDARD_PRICE * books.length);
            default:
                return Book.STANDARD_PRICE * books.length;
        }
    }

    private double threeBookDiscount(double originalPrice) {
        return originalPrice * 0.9d;
    }

    private double twoBookDiscount(double originalPrice) {
        return originalPrice * 0.95d;
    }
}
