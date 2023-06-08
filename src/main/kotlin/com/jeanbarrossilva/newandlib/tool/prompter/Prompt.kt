package com.jeanbarrossilva.newandlib.tool.prompter

interface Prompt {
    val content: String

    companion object {
        val empty = object : Prompt {
            override val content = ""
        }
    }
}
