package com.example.calculator.data

import com.example.calculator.R
import com.example.calculator.model.Calculator

object DataSource {
    val firstRowOptions = listOf(
        Calculator(option = "C", operation = "special"),
        Calculator(option = "( )", operation = "brackets"),
        Calculator(option = "%", operation = "special"),
        Calculator(option = "/", operation = "special"),
    )
    val secondRowOptions = listOf(
        Calculator(option = "7", operation = "number"),
        Calculator(option = "8", operation = "number"),
        Calculator(option = "9", operation = "number"),
        Calculator(option = "X", operation = "special"),
    )
    val thirdRowOptions = listOf(
        Calculator(option = "4", operation = "number"),
        Calculator(option = "5", operation = "number"),
        Calculator(option = "6", operation = "number"),
        Calculator(option = "-", operation = "special"),
    )
    val fourthRowOptions = listOf(
        Calculator(option = "1", operation = "number"),
        Calculator(option = "2", operation = "number"),
        Calculator(option = "3", operation = "number"),
        Calculator(option = "+", operation = "special"),
    )
    val fifthRowOptions = listOf(
        Calculator(option = "", operation = "special"),
        Calculator(option = "0", operation = "number"),
        Calculator(option = ",", operation = "special"),
        Calculator(option = "=", operation = "result"),
    )
    val allRowOptions = listOf(
        Calculator(option = "C", operation = "special"),
        Calculator(option = "( )", operation = "brackets"),
        Calculator(option = "%", operation = "special"),
        Calculator(option = "/", operation = "special"),
        Calculator(option = "7", operation = "number"),
        Calculator(option = "8", operation = "number"),
        Calculator(option = "9", operation = "number"),
        Calculator(option = "X", operation = "special"),
        Calculator(option = "4", operation = "number"),
        Calculator(option = "5", operation = "number"),
        Calculator(option = "6", operation = "number"),
        Calculator(option = "-", operation = "special"),
        Calculator(option = "1", operation = "number"),
        Calculator(option = "2", operation = "number"),
        Calculator(option = "3", operation = "number"),
        Calculator(option = "+", operation = "special"),
        Calculator(option = "", operation = "special"),
        Calculator(option = "0", operation = "number"),
        Calculator(option = ",", operation = "special"),
        Calculator(option = "=", operation = "result"),
    )
}