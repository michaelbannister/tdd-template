
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HarryPotterTest {
    @Test fun priceSingleCopy() {
        assertBooks(HarryPotter.ONE, cost=800)
    }

    @Test fun priceMultipleCopiesOfOneBook() {
        assertBooks(HarryPotter.ONE, HarryPotter.ONE, HarryPotter.ONE, cost=2400)
    }

    @Test fun applyDiscountToTwoDifferentBooks() {
        assertBooks(HarryPotter.ONE, HarryPotter.TWO, cost=1520)
    }

    @Test fun applyDiscountToPartOfBasket() {
        assertBooks(HarryPotter.ONE, HarryPotter.ONE, HarryPotter.TWO, cost=2320)
    }
}

class BundlerTest {
    @Test fun allDifferentBooksMakeOneBundle() {
        val bundler = Bundler(HarryPotter.ONE, HarryPotter.TWO, HarryPotter.THREE)
        assertThat(bundler.nextBundle()).isEqualTo(Bundle(HarryPotter.ONE, HarryPotter.TWO, HarryPotter.THREE))
    }
}

fun assertBooks(vararg books: HarryPotter, cost: Int) =
        assertThat(Pricer().price(*books)).isEqualTo(cost)