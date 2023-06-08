package com.jeanbarrossilva.newandlib.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt

internal object ProjectTypeNamespacePrompt : Prompt {
    override val content = "What's the namespace of the library module?"
}