private val powersOfTen = listOf(1000, 100, 10, 1)

fun Int.toRoman(): String {
    powersOfTen.forEach { unit ->
        if (this >= unit) {
            return unit.toRomanDigit().repeat(this / unit)
        }
    }
    throw RomanNumeralException("Can't yet convert ${this} to Roman numerals")
}

fun toDecimalPlaceValues(number: Int): List<Int> {
    val largestPowerNeeded = powersOfTen.find { number > it } ?: 1
    if (largestPowerNeeded == 1) {
        return listOf(number)
    } else {
        val multiplier = number / largestPowerNeeded
        val remainder = number % largestPowerNeeded
        val placeValueForThisPower = multiplier * largestPowerNeeded
        return listOf(placeValueForThisPower) + toDecimalPlaceValues(remainder)
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