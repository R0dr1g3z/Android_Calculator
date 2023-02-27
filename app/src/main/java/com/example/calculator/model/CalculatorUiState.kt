package com.example.calculator.model

data class CalculatorUiState (
    val result: String = "",
    val actualResult: Long = 22252355222,
    val bracketCount: Int = 0
        )