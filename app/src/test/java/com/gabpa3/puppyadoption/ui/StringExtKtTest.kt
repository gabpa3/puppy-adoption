package com.gabpa3.puppyadoption.ui

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtKtTest {

    @Test
    fun `check title conversion when string has underscore delimiter`() {
        val input = "BORDER_COLLIE"
        val expected = "Border Collie"

        val result = input.toTitleCase()

        assertEquals(expected, result)
    }

    @Test
    fun `check title conversion for a word`() {
        val input = "BOX"
        val expected = "Box"

        val result = input.toTitleCase()

        assertEquals(expected, result)
    }
}
