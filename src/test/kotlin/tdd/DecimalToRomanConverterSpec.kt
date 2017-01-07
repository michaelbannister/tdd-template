package tdd

import org.assertj.core.api.KotlinAssertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class DecimalToRomanConverterSpec : Spek({
    describe("Int.toRoman extension method") {
        arrayOf(
            Pair(1, "I"),
            Pair(2, "II"),
            Pair(10, "X"),
            Pair(20, "XX"),
            Pair(100, "C"),
            Pair(200, "CC"),
            Pair(1000, "M"),
            Pair(2000, "MM"),
            Pair(11, "XI"),
            Pair(3012, "MMMXII"), // I didn't expect this to fail, just checking
            Pair(5, "V"),
            Pair(50, "L"),
            Pair(500, "D"),
            Pair(1555, "MDLV"), // again, just checking
            Pair(4, "IV"),
            Pair(444, "CDXLIV"), // again, just checking
            Pair(666, "DCLXVI"),
            Pair(777, "DCCLXXVII"),
            Pair(888, "DCCCLXXXVIII"),
            Pair(999, "CMXCIX"),
            Pair(1888, "MDCCCLXXXVIII") // longest Roman numeral year
        ).forEach {
            val (number, roman) = it
            it("should convert ${number} to ${roman}") {
                assertThat(number.toRoman()).isEqualTo(roman)
            }
        }
    }
    describe("toDecimalPlaceValues function") {
        arrayOf(
            Pair(9, "9*1"),
            Pair(14, "1*10 + 4*1"),
            Pair(4025, "4*1000 + 2*10 + 5*1"),
            Pair(10, "1*10")
        ).forEach {
            val (number, placevalueString) = it
            it("should split ${number} into place values ${placevalueString}") {
                assertThat(toDecimalPlaceValues(number).format()).isEqualTo(placevalueString)
            }
        }

    }
})

private fun List<PlaceValue>.format() = this.joinToString(separator = " + ")


