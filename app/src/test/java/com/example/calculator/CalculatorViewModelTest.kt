package com.example.calculator

import com.example.calculator.ui.CalculatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorViewModelTest {
    private val viewModel = CalculatorViewModel()

    @Test
    fun testing_backspace_button(){
        viewModel.addToResult("2")
        viewModel.addToResult("5")
        viewModel.addToResult("7")
        viewModel.backspaceButton()
        viewModel.addToResult("8")

        assertEquals("258", viewModel.uiState.value.result)
    }
    @Test
    fun testing_reset_result() {
        viewModel.addToResult("1")
        viewModel.addToResult("5")
        viewModel.addToResult("5")
        viewModel.resetResult()

        assertEquals("", viewModel.uiState.value.result)
    }

    @Test
    fun testing_add_options_to_result() {
        viewModel.addToResult("1")
        viewModel.addToResult("2")
        viewModel.addToResult("3")
        viewModel.addToResult("4")
        viewModel.addToResult("5")
        viewModel.addToResult("6")
        viewModel.addToResult("7")
        viewModel.addToResult("8")
        viewModel.addToResult("9")

        assertEquals("123456789", viewModel.uiState.value.result)
    }
}