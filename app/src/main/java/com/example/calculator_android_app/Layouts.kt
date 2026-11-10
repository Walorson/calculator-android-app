package com.example.calculator_android_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// UKŁAD PIONOWY
@Composable
fun PortraitLayout(
    expression: String,
    result: String,
    onButtonClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Display(
            expression = expression,
            result = result
        )

        VerticalButtonGrid(
            modifier = Modifier.weight(1f),
            onButtonClick = onButtonClick
        )
    }
}

// UKŁAD POZIOMY

@Composable
fun LandscapeLayout(
    expression: String,
    result: String,
    onButtonClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Display(
            expression = expression,
            result = result,
            compact = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // LEWA STRONA - funkcje naukowe
            HorizontalButtonGrid(
                modifier = Modifier
                    .weight(0.85f)
                    .fillMaxHeight(),
                onButtonClick = onButtonClick
            )

            // PRAWA STRONA - podstawowy kalkulator
            VerticalButtonGrid(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight(),
                onButtonClick = onButtonClick
            )
        }
    }
}