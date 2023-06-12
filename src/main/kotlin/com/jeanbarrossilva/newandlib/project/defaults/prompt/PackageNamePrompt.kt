package com.jeanbarrossilva.newandlib.project.defaults.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt

internal class PackageNamePrompt(typeName: String) : Prompt() {
    override val message = "What's the package name of the $typeName?"
}
