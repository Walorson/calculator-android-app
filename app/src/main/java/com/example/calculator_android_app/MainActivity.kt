package com.example.calculator_android_app

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator_android_app.ui.theme.CalculatorandroidappTheme
import com.example.calculator_android_app.Display
import com.example.calculator_android_app.VerticalButtonGrid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var expression by rememberSaveable {
                mutableStateOf("")
            }

            val configuration = LocalConfiguration.current

            when (configuration.orientation) {

                Configuration.ORIENTATION_LANDSCAPE -> {
                    LandscapeLayout(
                        expression = expression,
                        onButtonClick = { button ->
                            expression += button
                        }
                    )
                }

                else -> {
                    PortraitLayout(
                        expression = expression,
                        onButtonClick = { button ->
                            expression += button
                        }
                    )
                }
            }

        }
    }
}