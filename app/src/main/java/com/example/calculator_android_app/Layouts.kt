package com.example.calculator_android_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// UKŁAD PIONOWY
@Composable
fun PortraitLayout(
    expression: String,
    onButtonClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080D18))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Display(
            expression = expression,
            result = ""
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
    onButtonClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080D18))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Display(
            expression = expression,
            result = "",
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