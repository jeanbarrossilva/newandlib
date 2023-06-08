package com.jeanbarrossilva.newandlib.tool.prompter

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class PrompterTests {
    private val prompter = TestPrompter()
    private val prompt = Prompt.empty

    private val input
        get() = prompter[prompt]

    @AfterTest
    fun tearDown() {
        prompter.input(null)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null input WHEN responding with it THEN the prompt is repeated`() {
        assertFailsWith<StackOverflowError> {
            runTest {
                prompt()
            }
        }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null input WHEN responding with it to a prompt with a default value THEN it is not repeated`() {
        runTest { prompt(default = "default-input") }
        assertEquals("default-input", input)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN an input WHEN inputting it THEN it is saved`() {
        prompter.input("input")
        runTest { prompt() }
        assertEquals("input", input)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN an input constrained to options WHEN inputting one of them THEN it is saved`() {
        prompter.input("red")
        runTest {  }
    }

    private fun prompt(default: String? = null): String {
        return prompter.prompt(prompt, default)
    }
}
