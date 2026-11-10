package com.example.calculator_android_app

import com.example.kalkulator.CalculatorEngine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CalculatorEngineTest {

    @Test
    fun additionAndMultiplicationOrder() {
        assertEquals("6", CalculatorEngine.calculate("2+2*2"))
    }

    @Test
    fun parentheses() {
        assertEquals("8", CalculatorEngine.calculate("(2+2)*2"))
    }

    @Test
    fun divisionByZero() {
        assertEquals(CalculatorEngine.error, CalculatorEngine.calculate("1/0"))
    }

    @Test
    fun incompleteExpression() {
        assertEquals("2", CalculatorEngine.calculate("2+"))
    }

    @Test
    fun unclosedParenthesis() {
        assertEquals("", CalculatorEngine.calculate("((2+2)"))
    }

    @Test
    fun emptyExpression() {
        assertEquals("", CalculatorEngine.calculate(""))
    }

    @Test
    fun squareRootOfNegativeNumber() {
        assertEquals(CalculatorEngine.error, CalculatorEngine.calculate("sqrt(-1)"))
    }

    @Test
    fun largeNumbers() {
        val result = CalculatorEngine.calculate(
            "1234567890*1234567890"
        )

        assertTrue(result != CalculatorEngine.error)
        assertTrue(result.isNotEmpty())

        val expected = 1234567890.0 * 1234567890.0
        val actual = result.toDouble()

        assertEquals(expected, actual, 1.0)
    }
}