
package com.example.calculator_android_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalButtonGrid(
    modifier: Modifier = Modifier,
    onButtonClick: (String) -> Unit
) {
    val buttons = listOf(
        "C", "⌫", "(", ")",
        "7", "8", "9", "÷",
        "4", "5", "6", "×",
        "1", "2", "3", "-",
        "0", ".", "+", "="
    )

    BoxWithConstraints(modifier = modifier) {

        val spacing = 4.dp

        val buttonHeight =
            (maxHeight - spacing * 4) / 5

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
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
                    onClick = {
                        onButtonClick(buttons[index])
                    }
                )
            }
        }
    }
}

