package com.jeanbarrossilva.newandlib.tool.prompter

interface Prompt {
    val content: String

    val default: String?
        get() = null
}
