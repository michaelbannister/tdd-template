package org.bannisters

import assertk.assertThat
import assertk.assertions.isNotNull
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun `app should have a greeting`() {
        val classUnderTest = App()
        assertThat(classUnderTest.greeting, "greeting").isNotNull()
    }
}
