class Pricer {

    val costOfOneBook = 800

    fun price(vararg books: HarryPotter): Int {
        val uniqueBooks = books.toSet().size

        val priceBeforeDiscount = costOfOneBook * books.size
        val discountedPrice = priceBeforeDiscount * discountMultiplierForSetOfSize(uniqueBooks)
        return Math.round(discountedPrice).toInt()
    }
}

fun discountMultiplierForSetOfSize(size: Int) =
        when (size) {
            1 -> 1.0
            2 -> 0.95
            else -> throw RuntimeException("haven't got to this yet")
        }

class Bundler(private vararg val basket: HarryPotter) {
    private var remainingItems: MutableList<HarryPotter>
    init {
        remainingItems = basket.toMutableList()
    }

    fun nextBundle(): Bundle = Bundle(*basket)
}

data class Bundle(val contents: Set<HarryPotter>) {
    constructor(vararg contents: HarryPotter) : this(contents.toSet())
}

enum class HarryPotter {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN
}