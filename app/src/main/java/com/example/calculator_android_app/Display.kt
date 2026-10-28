
package com.example.kalkulator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Display(
    expression: String,
    result: String
) {
    val shape = RoundedCornerShape(16.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .background(
                color = Color(0xFF101522),
                shape = shape
            )
            .border(
                width = 1.dp,
                color = Color(0xFF26364D),
                shape = shape
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "WPROWADZONE DZIAŁANIE",
            color = Color(0xFF75849B),
            fontSize = 10.sp
        )

        Text(
            text = expression.ifEmpty { "0" },
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFEAF2FF),
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            maxLines = 1
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "WYNIK NA BIEŻĄCO",
                color = Color(0xFF75849B),
                fontSize = 10.sp
            )

            Text(
                text = result,
                color = Color(0xFF168BFF),
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
