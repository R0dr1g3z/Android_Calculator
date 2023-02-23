package com.example.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.data.DataSource.allRowOptions
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CalculatorApp() {
    CalculatorScreen()
}

@Composable
fun CalculatorScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.End
    ) {
        TopScreen(modifier = Modifier.weight(1f))
        BottomScreen()
    }
}

@Composable
fun TopScreen(modifier: Modifier = Modifier) {
    Text(
        "41256985478523652247",
        color = colorScheme.primary,
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier,
    )
    Text(
        "9240982342",
        color = colorScheme.primary,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun BottomScreen() {
    var count = 0

    repeat(5) {
        Row(horizontalArrangement = Arrangement.spacedBy(13.dp)) {
            repeat(4) {
                when (count) {
                    0 -> {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                        ) {
                            Text(
                                allRowOptions[count],
                                color = colorScheme.errorContainer,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                    in 1..3, 7, 11, 15 -> {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                        ) {
                            Text(
                                allRowOptions[count],
                                color = colorScheme.tertiary,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                    19 -> {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                            colors = ButtonDefaults.buttonColors(colorScheme.tertiary)
                        ) {
                            Text(
                                allRowOptions[count],
                                color = colorScheme.surface,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                    else -> {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                        ) {
                            Text(
                                allRowOptions[count],
                                color = colorScheme.primary,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                }
                count++
            }
        }
    }
}

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorTheme(useDarkTheme = true) {
        CalculatorApp()
    }
}
