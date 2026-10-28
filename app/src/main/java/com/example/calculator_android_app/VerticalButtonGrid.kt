
package com.example.kalkulator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val blue = 0xFF168BFF;
@Composable
fun VerticalButtonGrid(
    onButtonClick: (String) -> Unit
) {
    val buttons = listOf(
        "C", "⌫", "(", ")",
        "7", "8", "9", "÷",
        "4", "5", "6", "×",
        "1", "2", "3", "−",
        "0", ".", "+", "="
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(buttons) { index, button ->
            CalcButton(
                text = button,
                color = blue,
                onClick = {
                    onButtonClick(button)
                }
            )
        }
    }
}
