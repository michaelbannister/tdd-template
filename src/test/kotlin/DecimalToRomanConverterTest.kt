import org.junit.Test
import kotlin.test.assertEquals

class DecimalToRomanConverterTest {
    
    @Test fun `1 is written as I`() = assertEquals("I", 1.toRoman())
    
    @Test fun `2 is written as II`() = assertEquals("II", 2.toRoman())
}

