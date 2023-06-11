package com.jeanbarrossilva.newandlib.tool.prompter

internal class TestPrompt(override val default: String? = null, override val options: List<String> = emptyList()) :
    Prompt() {
    override val content = ""
}
