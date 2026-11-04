
package com.example.calculator_android_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val darkBlue = 0xFF325AFF;

@Composable
fun HorizontalButtonGrid(
    modifier: Modifier = Modifier,
    onButtonClick: (String) -> Unit
) {
    val buttons = listOf(
        "sin", "cos",
        "tan", "π",
        "√", "x^y",
        "ln", "e"
    )

    BoxWithConstraints(modifier = modifier) {

        val spacing = 4.dp

        val buttonHeight =
            (maxHeight - spacing * 3) / 4

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalArrangement = Arrangement.spacedBy(spacing),
            userScrollEnabled = false
        ) {
            items(buttons.size) { index ->
                CalcButton(
                    text = buttons[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(buttonHeight),
                    color = darkBlue,
                    onClick = {
                        onButtonClick(buttons[index])
                    }
                )
            }
        }
    }
}
