package com.jeanbarrossilva.newandlib.prompter

internal class TestPrompter : Prompter() {
    private var response: String? = null

    override fun onPrompt(key: String, prompt: String, default: String?): String? {
        return response
    }

    fun respond(response: String?) {
        this.response = response
    }
}
