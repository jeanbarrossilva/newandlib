package com.jeanbarrossilva.newandlib.tool.prompter

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class PrompterTests {
    private val TestPrompter.response
        get() = get(PROMPT_KEY)

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null response WHEN responding with it THEN the prompt is repeated`() {
        assertFailsWith<StackOverflowError> {
            promptWith(TestPrompter()) {
                respond(null)
                runTest { prompt() }
            }
        }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a null response WHEN responding with it to a prompt with a default value THEN it is not repeated`() {
        promptWith(TestPrompter()) {
            respond(null)
            runTest { prompt(default = "default-response") }
            assertEquals("default-response", response)
        }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a response WHEN responding with it THEN it is saved`() {
        promptWith(TestPrompter()) {
            respond("response")
            runTest { prompt() }
            assertEquals("response", response)
        }
    }

    private fun TestPrompter.prompt(key: String = PROMPT_KEY, default: String? = null): String {
        return prompt(key, prompt = "", default)
    }

    companion object {
        private const val PROMPT_KEY = "prompt"
    }
}
