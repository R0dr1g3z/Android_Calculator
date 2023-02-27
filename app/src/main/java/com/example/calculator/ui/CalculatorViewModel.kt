package com.example.calculator.ui

import androidx.lifecycle.ViewModel
import com.example.calculator.data.DataSource.allRowOptions
import com.example.calculator.model.Calculator
import com.example.calculator.model.CalculatorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun backspaceButton() {
        val result = _uiState.value.result.dropLast(1)
        _uiState.update { curr -> curr.copy(result = result) }
    }

    fun resetResult() {
        _uiState.update { curr -> curr.copy(result = "") }
    }

    fun addToResult(calculator: Calculator) {
        val result = _uiState.value.result
        when (calculator.operation) {
            "special" -> if (result.isNotEmpty() && result.lastOrNull() != calculator.option.last()
                && !checkIfLastCharIsSpecial(result)
            ) {
                _uiState.update { curr -> curr.copy(result = curr.result + calculator.option) }
            }
//            "brackets" -> _uiState.update { curr ->
//                curr.copy(
//                    result = curr.result + returnCorrectBracket(
//                        result
//                    )
//                )
//            }
            else -> _uiState.update { curr -> curr.copy(result = curr.result + calculator.option) }
        }
    }

//    private fun returnCorrectBracket(result: String): String {
//        var bracketCount = _uiState.value.bracketCount
//        return if (bracketCount > 0 && checkIfLastCharIsNumber(result)) {
//            bracketCount--
//            _uiState.update { curr -> curr.copy(bracketCount = bracketCount) }
//            ")"
//        } else {
//            bracketCount++
//            _uiState.update { curr -> curr.copy(bracketCount = bracketCount) }
//            "("
//        }
//    }

    private fun checkIfLastCharIsNumber(result: String): Boolean {
        val filteredOptions = allRowOptions.filter { it.operation == "number" }
        filteredOptions.forEach { item ->
            if (result.lastOrNull() == item.option.lastOrNull()) return true
        }
        return false
    }

    private fun checkIfLastCharIsSpecial(result: String): Boolean {
        val filteredOptions = allRowOptions.filter { it.operation == "special" }
        filteredOptions.forEach { item ->
            if (result.lastOrNull() == item.option.lastOrNull()) return true
        }
        return false
    }
}