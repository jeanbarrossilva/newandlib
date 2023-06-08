package com.jeanbarrossilva.newandlib.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt

internal object ProjectPathPrompt : Prompt {
    override val content = "Where would you like the project to be created?"
}
