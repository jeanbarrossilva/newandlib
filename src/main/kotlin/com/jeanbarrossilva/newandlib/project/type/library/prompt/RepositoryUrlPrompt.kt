package com.jeanbarrossilva.newandlib.project.type.library.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt

internal class RepositoryUrlPrompt : Prompt() {
    override val content = "What is the URL of the repository to which the project will be uploaded?"
    override val default = ""
}
