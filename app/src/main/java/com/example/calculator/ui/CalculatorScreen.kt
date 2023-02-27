package com.example.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.data.DataSource.fifthRowOptions
import com.example.calculator.data.DataSource.firstRowOptions
import com.example.calculator.data.DataSource.fourthRowOptions
import com.example.calculator.data.DataSource.secondRowOptions
import com.example.calculator.data.DataSource.thirdRowOptions
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CalculatorApp(calculatorViewModel: CalculatorViewModel = viewModel()) {
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    CalculatorScreen(
        result = calculatorUiState.result,
        addToResult = { calculatorViewModel.addToResult(it) },
        resetResult = { calculatorViewModel.resetResult() }
    )
}

@Composable
fun CalculatorScreen(result: String, addToResult: (String) -> Unit, resetResult: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ResultScreen(
            result = result, modifier = Modifier
                .weight(1f)
                .align(Alignment.End)
        )
        TopScreen(modifier = Modifier.align(Alignment.End))
        BottomScreen(addToResult = addToResult, resetResult = resetResult)
    }
}

@Composable
fun ResultScreen(result: String, modifier: Modifier) {
    if (result.length >= 25) {
        Text(
            result,
            color = colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
        )
    } else if (result.length >= 15) {
        Text(
            result,
            color = colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier
        )
    } else {
        Text(
            result,
            color = colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier
        )
    }

}

@Composable
fun TopScreen(modifier: Modifier) {

    Text(
        "9240982342",
        color = colorScheme.primary,
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier.padding(bottom = 16.dp)
    )
    IconButton(onClick = { /*TODO*/ }, modifier = modifier.padding(end = 18.dp, bottom = 8.dp)) {
        Icon(
            imageVector = Icons.Outlined.Backspace,
            contentDescription = null,
            tint = colorScheme.tertiary
        )
    }
}

@Composable
fun BottomScreen(addToResult: (String) -> Unit, resetResult: () -> Unit) {

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        firstRowOptions.forEach { item ->
            if (item.option == "C") {
                Button(
                    onClick = resetResult,
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.errorContainer,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            } else {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.tertiary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        secondRowOptions.forEach { item ->
            if (item.option == "X") {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.tertiary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            } else {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        thirdRowOptions.forEach { item ->
            if (item.option == "-") {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.tertiary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            } else {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        fourthRowOptions.forEach { item ->
            if (item.option == "+") {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.tertiary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            } else {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        fifthRowOptions.forEach { item ->
            if (item.option == "=") {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.tertiary)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.surface,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            } else {
                Button(
                    onClick = { addToResult(item.option) },
                    modifier = Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
                ) {
                    Text(
                        item.option,
                        color = colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }

//    var count = 0
//    repeat(5) {
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            repeat(4) {
//                when (count) {
//                    0 -> {
//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier.size(80.dp),
//                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
//                        ) {
//                            Text(
//                                stringResource(allRowOptions[count].option),
//                                color = colorScheme.errorContainer,
//                                style = MaterialTheme.typography.headlineLarge
//                            )
//                        }
//                    }
//                    in 1..3, 7, 11, 15 -> {
//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier.size(80.dp),
//                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
//                        ) {
//                            Text(
//                                stringResource(allRowOptions[count].option),
//                                color = colorScheme.tertiary,
//                                style = MaterialTheme.typography.headlineLarge
//                            )
//                        }
//                    }
//                    19 -> {
//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier.size(80.dp),
//                            colors = ButtonDefaults.buttonColors(colorScheme.tertiary)
//                        ) {
//                            Text(
//                                stringResource(allRowOptions[count].option),
//                                color = colorScheme.surface,
//                                style = MaterialTheme.typography.headlineLarge
//                            )
//                        }
//                    }
//                    else -> {
//                        Button(
//                            onClick = { },
//                            modifier = Modifier.size(80.dp),
//                            colors = ButtonDefaults.buttonColors(colorScheme.surfaceVariant)
//                        ) {
//                            Text(
//                                stringResource(allRowOptions[count].option),
//                                color = colorScheme.primary,
//                                style = MaterialTheme.typography.headlineLarge
//                            )
//                        }
//                    }
//                }
//                count++
//            }
//        }
//    }
}

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorTheme(useDarkTheme = true) {
        CalculatorApp()
    }
}
