package com.jeanbarrossilva.newandlib.project.defaults.prompt

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import java.nio.file.Path

internal class ProjectPathPrompt : Prompt {
    override val content = "Where would you like the project to be created?"
    override val default = Path.of("").toAbsolutePath().toString()
}
