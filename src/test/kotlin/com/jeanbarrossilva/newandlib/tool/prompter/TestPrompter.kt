package com.jeanbarrossilva.newandlib.tool.prompter

internal class TestPrompter : Prompter() {
    private var input: String? = null

    override fun onPrompt(prompt: Prompt): String? {
        return input
    }

    fun input(input: String?) {
        this.input = input
    }
}
