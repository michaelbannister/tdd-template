private val powersOfTen = listOf(1000, 100, 10, 1)

fun Int.toRoman(): String {
    val placeValues = toDecimalPlaceValues(this)
    return placeValues.map {
        if (it.multiplier == 5) {
            (5 * it.magnitude).toRomanDigit()
        } else {
            it.magnitude.toRomanDigit().repeat(it.multiplier)
        }
    }.joinToString(separator = "")
}

fun toDecimalPlaceValues(number: Int): List<PlaceValue> {
    if (number == 0) {
        return emptyList()
    }
    val largestPowerNeeded = powersOfTen.find { number >= it } ?: 1
    if (largestPowerNeeded == 1) {
        return listOf(PlaceValue(multiplier = number, magnitude = 1))
    } else {
        val multiplier = number / largestPowerNeeded
        val remainder = number % largestPowerNeeded
        return listOf(PlaceValue(multiplier, magnitude = largestPowerNeeded)) + toDecimalPlaceValues(remainder)
    }
}

private fun Int.toRomanDigit(): String = when(this) {
    1000 -> "M"
    500 -> "D"
    100 -> "C"
    50 -> "L"
    10 -> "X"
    5 -> "V"
    1 -> "I"
    else -> throw RomanNumeralException("No mapping to symbol for ${this}")
}

internal class RomanNumeralException(message: String) : RuntimeException(message)

data class PlaceValue(val multiplier: Int, val magnitude: Int) {
    override fun toString(): String = "$multiplier*$magnitude"
}