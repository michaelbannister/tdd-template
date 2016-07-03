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
                arrayOf(2000, "MM")
            )
    
    @Test
    @Parameters
    fun testPlaceValues(number: Int, placeValueRepresentation: String) {
        assertEquals(placeValueRepresentation, formatPlaceValues(toDecimalPlaceValues(number)))
    }

    private fun parametersForTestPlaceValues() =
            arrayOf(
                arrayOf(9, "9"),
                arrayOf(14, "10+4"),
                arrayOf(4025, "4000+20+5")
            )

    private fun formatPlaceValues(placeValues: List<PlaceValue>) = placeValues.joinToString(separator = "+")
}

