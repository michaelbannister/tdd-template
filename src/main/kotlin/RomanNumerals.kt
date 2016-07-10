private val powersOfTen = listOf(1000, 100, 10, 1)

fun Int.toRoman(): String {
    val placeValues = toDecimalPlaceValues(this)
    return placeValues.map {
        fun one() = it.magnitude.toRomanDigit()
        fun five() = (it.magnitude * 5).toRomanDigit()
        fun ten() = (it.magnitude * 10).toRomanDigit()
        when (it.multiplier) {
            in 1..3 -> one().repeat(it.multiplier) 
            4 -> one() + five()
            5 -> five()
            in 6..8 -> five() + one().repeat(it.multiplier - 5)
            9 -> one() + ten()
            else -> ""
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