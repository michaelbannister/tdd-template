package org.bannisters

import ch.tutteli.atrium.api.fluent.en_GB.notToBeNull
import ch.tutteli.atrium.api.verbs.expect
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun `app should have a greeting`() {
        val classUnderTest = App()
        expect(classUnderTest.greeting).notToBeNull()
    }
}
