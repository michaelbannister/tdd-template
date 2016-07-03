fun Int.toRoman(): String {
    val powersOfTen = listOf(1000, 100, 10, 1)
    powersOfTen.forEach { unit ->
        if (this >= unit) {
            return symbolFor(unit).repeat(this / unit)
        }
    }
    throw RomanNumeralException("Can't yet convert ${this} to Roman numerals")
}

fun symbolFor(unit: Int): String {
    return when(unit) {
        1000 -> "M"
        100 -> "C"
        10 -> "X"
        1 -> "I"
        else -> throw RomanNumeralException("No mapping to symbol for ${unit}")
    }        
}

class RomanNumeralException(message: String) : RuntimeException(message)