package com.jeanbarrossilva.newandlib.generator

import com.jeanbarrossilva.newandlib.Generator
import com.jeanbarrossilva.newandlib.Prompts
import com.jeanbarrossilva.newandlib.prompter.Prompter
import com.jeanbarrossilva.newandlib.writer.FileWriter

internal class MainGenerator(override val prompter: Prompter) : Generator() {
    override val fileWriter = FileWriter(prompter[Prompts.PROJECT_PATH]!!)
}
