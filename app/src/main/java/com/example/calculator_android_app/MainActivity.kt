package com.example.calculator_android_app

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
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
import com.example.calculator_android_app.Display
import com.example.calculator_android_app.VerticalButtonGrid
import com.example.compose.AppTheme
import com.example.kalkulator.CalculatorEngine
import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.License
import kotlin.collections.plusAssign
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        License.iConfirmNonCommercialUse("Szymon Gniadek")

        enableEdgeToEdge()
        setContent {
            AppTheme(
                darkTheme = true,
                dynamicColor = false
            ) {

                var expression by rememberSaveable {
                    mutableStateOf("")
                }
                var result by rememberSaveable {
                    mutableStateOf("")
                }

                fun buttonEvent(char: String)
                {
                    when (char) {
                        "=" -> {
                            result = CalculatorEngine.calculate(expression)
                            if (result != CalculatorEngine.error)
                                expression = result
                        }

                        "C" -> {
                            expression = ""
                            result = ""
                        }

                        "⌫" -> {
                            expression = expression.slice(0..expression.length-2)
                        }

                        else -> {
                            expression += char
                        }
                    }
                }

                val configuration = LocalConfiguration.current

                when (configuration.orientation) {

                    Configuration.ORIENTATION_LANDSCAPE -> {
                        LandscapeLayout(
                            expression = expression,
                            result = result,
                            onButtonClick = { charButton ->
                                buttonEvent(charButton)
                            }
                        )
                    }

                    else -> {
                        PortraitLayout(
                            expression = expression,
                            result = result,
                            onButtonClick = { charButton ->
                                buttonEvent(charButton)
                            }
                        )
                    }
                }
            }

        }
    }
}