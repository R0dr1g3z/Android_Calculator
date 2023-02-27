package com.example.calculator.data

import com.example.calculator.R
import com.example.calculator.model.Calculator

object DataSource {
    val firstRowOptions = listOf(
        Calculator(option = "C"),
        Calculator(option = "( )"),
        Calculator(option = "%"),
        Calculator(option = "/"),
    )
    val secondRowOptions = listOf(
        Calculator(option = "7"),
        Calculator(option = "8"),
        Calculator(option = "9"),
        Calculator(option = "X"),
    )
    val thirdRowOptions = listOf(
        Calculator(option = "4"),
        Calculator(option = "5"),
        Calculator(option = "6"),
        Calculator(option = "-"),
    )
    val fourthRowOptions = listOf(
        Calculator(option = "1"),
        Calculator(option = "2"),
        Calculator(option = "3"),
        Calculator(option = "+"),
    )
    val fifthRowOptions = listOf(
        Calculator(option = ""),
        Calculator(option = "0"),
        Calculator(option = ","),
        Calculator(option = "="),
    )
}