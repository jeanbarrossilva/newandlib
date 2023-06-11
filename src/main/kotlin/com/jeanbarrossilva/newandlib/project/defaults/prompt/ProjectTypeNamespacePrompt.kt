package com.jeanbarrossilva.newandlib.project.defaults.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class ProjectTypeNamespacePrompt(prompter: Prompter, typeName: String) : Prompt() {
    override val content = "What's the namespace of the $typeName module?"
    override val default = prompter.get<GroupIDPrompt>()
}
