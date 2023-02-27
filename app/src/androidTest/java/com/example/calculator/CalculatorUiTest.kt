package com.example.calculator

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.calculator.ui.CalculatorApp
import org.junit.Rule
import org.junit.Test

class CalculatorUiTest {
    @get:Rule
    val rule = createComposeRule()

    private val buttonOne = hasText("1") and hasClickAction()
    private val buttonTwo = hasText("2") and hasClickAction()
    private val buttonThree = hasText("3") and hasClickAction()
    private val buttonFour = hasText("4") and hasClickAction()
    private val buttonFive = hasText("5") and hasClickAction()
    private val buttonSix = hasText("6") and hasClickAction()
    private val buttonSeven = hasText("7") and hasClickAction()
    private val buttonEight = hasText("8") and hasClickAction()
    private val buttonNine = hasText("9") and hasClickAction()
    private val buttonZero = hasText("0") and hasClickAction()
    private val buttonCancel = hasText("C") and hasClickAction()
    private val buttonBackspace = hasContentDescription("backspace") and hasClickAction()
    private val buttonComma = hasText(",") and hasClickAction()
    private val buttonAdd = hasText("+") and hasClickAction()
    private val buttonSubtract = hasText("-") and hasClickAction()
    private val buttonDivide = hasText("/") and hasClickAction()
    private val buttonMulti = hasText("X") and hasClickAction()
    private val buttonPercentage = hasText("%") and hasClickAction()
    private val buttonBrackets = hasText("( )") and hasClickAction()

    @Test
    fun test_ui_brackets(){
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonBrackets).performClick()
    }
    @Test
    fun test_ui_special_buttons_duplicate_char(){
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonThree).performClick()
        rule.onNode(buttonPercentage).performClick()
        rule.onNode(buttonPercentage).performClick()
        rule.onNode(buttonDivide).performClick()
        rule.onNode(buttonDivide).performClick()
        rule.onNode(buttonMulti).performClick()
        rule.onNode(buttonMulti).performClick()
        rule.onNode(buttonSubtract).performClick()
        rule.onNode(buttonSubtract).performClick()
        rule.onNode(buttonAdd).performClick()
        rule.onNode(buttonAdd).performClick()

        rule.onNodeWithText("13%").assertExists()
        rule.onNodeWithText("13%%//XX--++").assertDoesNotExist()
    }
    @Test
    fun test_ui_special_buttons_first_char() {
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonPercentage).performClick()
        rule.onNode(buttonDivide).performClick()
        rule.onNode(buttonMulti).performClick()
        rule.onNode(buttonSubtract).performClick()
        rule.onNode(buttonAdd).performClick()

        rule.onNodeWithText("%/X-+").assertDoesNotExist()
        rule.onNode(hasText("%") and hasNoClickAction())
        rule.onNode(hasText("/") and hasNoClickAction())
        rule.onNode(hasText("X") and hasNoClickAction())
        rule.onNode(hasText("-") and hasNoClickAction())
        rule.onNode(hasText("+") and hasNoClickAction())
    }

    @Test
    fun test_ui_backspace_button() {
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonFive).performClick()
        rule.onNode(buttonEight).performClick()
        rule.onNode(buttonBackspace).performClick()

        rule.onNodeWithText("15").assertExists()
        rule.onNodeWithText("158").assertDoesNotExist()

    }

    @Test
    fun test_ui_reset_result() {
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonThree).performClick()
        rule.onNode(buttonFive).performClick()
        rule.onNode(buttonCancel).performClick()

        rule.onNodeWithText("135").assertDoesNotExist()
    }

    @Test
    fun test_ui_addResult() {
        rule.setContent { CalculatorApp() }

        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonAdd).performClick()
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonSubtract).performClick()
        rule.onNode(buttonThree).performClick()
        rule.onNode(buttonMulti).performClick()
        rule.onNode(buttonFour).performClick()
        rule.onNode(buttonDivide).performClick()
        rule.onNode(buttonFive).performClick()
        rule.onNode(buttonSix).performClick()
        rule.onNode(buttonPercentage).performClick()
        rule.onNode(buttonSeven).performClick()
        rule.onNode(buttonEight).performClick()
        rule.onNode(buttonNine).performClick()
        rule.onNode(buttonComma).performClick()
        rule.onNode(buttonZero).performClick()


        rule.onNodeWithText("11+2-3X4/56%789,0").assertExists()
    }
}