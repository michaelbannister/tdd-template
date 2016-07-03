import org.junit.Test
import kotlin.test.assertEquals

class DecimalToRomanConverterTest {
    
    @Test fun `1 is written as I`() {
        assertEquals("I", 1.toRoman())
    }
}

