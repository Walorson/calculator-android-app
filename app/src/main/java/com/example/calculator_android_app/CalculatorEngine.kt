
package com.example.kalkulator

import org.mariuszgromada.math.mxparser.Expression

object CalculatorEngine {

    val error = "ERROR";
    fun calculate(expression: String): String {
        if (expression.isBlank()) return ""

        return try {
            val result = Expression(expression).calculate()

            if (result.isNaN() || result.isInfinite()) {
                "ERROR"
            } else {
                // Usuwa końcówkę .0 dla liczb całkowitych
                if (result % 1.0 == 0.0) {
                    result.toLong().toString()
                } else {
                    result.toString()
                }
            }
        } catch (e: Exception) {
            "ERROR"
        }
    }
}
