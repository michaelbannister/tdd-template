private val powersOfTen = listOf(1000, 100, 10, 1)

fun Int.toRoman(): String {
    val placeValues = toDecimalPlaceValues(this)
    return placeValues.map {
        it.unit.toRomanDigit().repeat(it.multiplier)
    }.joinToString(separator = "")
}

fun toDecimalPlaceValues(number: Int): List<PlaceValue> {
    if (number == 0) {
        return emptyList()
    }
    val largestPowerNeeded = powersOfTen.find { number >= it } ?: 1
    if (largestPowerNeeded == 1) {
        return listOf(PlaceValue(number, 1))
    } else {
        val multiplier = number / largestPowerNeeded
        val remainder = number % largestPowerNeeded
        return listOf(PlaceValue(multiplier, largestPowerNeeded)) + toDecimalPlaceValues(remainder)
    }
}

private fun Int.toRomanDigit(): String = when(this) {
    1000 -> "M"
    100 -> "C"
    10 -> "X"
    1 -> "I"
    else -> throw RomanNumeralException("No mapping to symbol for ${this}")
}

internal class RomanNumeralException(message: String) : RuntimeException(message)

data class PlaceValue(val multiplier: Int, val unit: Int) {
    override fun toString(): String = "$multiplier*$unit"
}