
package com.example.kalkulator

import org.mariuszgromada.math.mxparser.Expression

object CalculatorEngine {

    val error = "ERROR";

    fun calculate(expression: String): String {
        if (expression.isBlank()) return ""

        return try {
            val parsedExpression = Expression(expression)

            if (!parsedExpression.checkSyntax()) {
                return ""
            }

            val result = parsedExpression.calculate()

            if (result.isNaN() || result.isInfinite()) {
                error
            } else {
                if (result % 1.0 == 0.0) {
                    result.toLong().toString()
                } else {
                    result.toString()
                }
            }
        } catch (e: Exception) {
            error
        }
    }

}
