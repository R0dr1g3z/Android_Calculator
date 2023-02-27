package com.example.calculator.ui

import androidx.lifecycle.ViewModel
import com.example.calculator.model.CalculatorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun resetResult(){
        _uiState.update { curr -> curr.copy(result = "") }
    }
    fun addToResult(option: String) {
        _uiState.update { curr -> curr.copy(result = curr.result + option) }
    }
}