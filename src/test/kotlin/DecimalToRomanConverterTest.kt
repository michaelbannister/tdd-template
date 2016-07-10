import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitParamsRunner::class)
class DecimalToRomanConverterTest {

    @Test
    @TestCaseName("{0} is written as {1}")
    @Parameters
    fun testIntToRomanConversion(number: Int, romanRepresentation: String) {
        assertEquals(romanRepresentation, number.toRoman(), "Incorrect conversion of ${number} to Roman numerals")
    }

    private fun parametersForTestIntToRomanConversion() =
            arrayOf(
                arrayOf(1, "I"),
                arrayOf(2, "II"),
                arrayOf(10, "X"),
                arrayOf(20, "XX"),
                arrayOf(100, "C"),
                arrayOf(200, "CC"),
                arrayOf(1000, "M"),
                arrayOf(2000, "MM"),
                arrayOf(11, "XI"),
                arrayOf(3012, "MMMXII"), // I didn't expect this to fail, just checking
                arrayOf(5, "V"),
                arrayOf(50, "L"),
                arrayOf(500, "D"),
                arrayOf(1555, "MDLV"), // again, just checking
                arrayOf(4, "IV"),
                arrayOf(444, "CDXLIV") // again, just checking
            )
    
    @Test
    @Parameters
    fun testPlaceValues(number: Int, placeValueRepresentation: String) {
        assertEquals(placeValueRepresentation, formatPlaceValues(toDecimalPlaceValues(number)))
    }

private fun parametersForTestPlaceValues() =
        arrayOf(
            arrayOf(9, "9*1"),
            arrayOf(14, "1*10 + 4*1"),
            arrayOf(4025, "4*1000 + 2*10 + 5*1"),
            arrayOf(10, "1*10")
        )

private fun formatPlaceValues(placeValues: List<PlaceValue>) = placeValues.joinToString(separator = " + ")
}

