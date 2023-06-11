package com.jeanbarrossilva.newandlib.tool.prompter

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.assertThrows

internal class PrompterTests {
    private val prompter = TestPrompter()

    @AfterTest
    fun tearDown() {
        prompter.input(null)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null input WHEN responding with it THEN the prompt is repeated`() {
        assertFailsWith<StackOverflowError> {
            runTest {
                prompter.prompt(TestPrompt())
            }
        }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null input WHEN responding with it to a prompt with a default value THEN it is not repeated`() {
        runTest { prompter.prompt(TestPrompt(default = "default-input")) }
        assertEquals("default-input", prompter.require<TestPrompt>())
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN an input WHEN inputting it THEN it is saved`() {
        prompter.input("input")
        runTest { prompter.prompt(TestPrompt()) }
        assertEquals("input", prompter.require<TestPrompt>())
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN an input constrained to options WHEN inputting one of them THEN it is saved`() {
        prompter.input("red")
        runTest { prompter.prompt(TestPrompt(options = listOf("blue", "red"))) }
        assertEquals("red", prompter.require<TestPrompt>())
    }

    @Disabled
    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN an input constrained to options WHEN inputting none of them THEN the prompt is repeated`() {
        assertFailsWith<StackOverflowError> {
            prompter.input("white")
            runTest { prompter.prompt(TestPrompt(options = listOf("blue", "red"))) }
        }
    }

    @Test
    fun `GIVEN unprovided input to a prompt WHEN requiring it THEN it throws`() {
        assertThrows<IllegalStateException> {
            prompter.require<TestPrompt>()
        }
    }
}
