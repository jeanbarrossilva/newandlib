package com.jeanbarrossilva.newandlib.tool.prompter

internal class TestPrompt private constructor(override val default: String? = null) : Prompt {
    override val content = ""

    companion object {
        val empty = TestPrompt()

        infix fun defaultingTo(default: String): TestPrompt {
            return TestPrompt(default)
        }
    }
}
