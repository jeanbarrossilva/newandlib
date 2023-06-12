package com.jeanbarrossilva.newandlib.request

import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal object ProjectGeneratorRequester {
    fun request(prompter: Prompter): ProjectGenerator {
        val libraryHandler = LibraryProjectGeneratorRequestHandler(prompter, next = null)
        val appHandler = AppProjectGeneratorRequestHandler(prompter, libraryHandler)
        val prompt = object : Prompt() {
            override val message = "What type of project do you want to generate?"
            override val options =
                listOf(AppProjectGeneratorRequestHandler.REQUEST, LibraryProjectGeneratorRequestHandler.REQUEST)
        }
        val request = prompter.prompt(prompt)
        return appHandler.handle(request)
    }
}
