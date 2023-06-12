package com.jeanbarrossilva.newandlib.request

import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.library.LibraryProjectGenerator
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class LibraryProjectGeneratorRequestHandler(private val prompter: Prompter, override val next: ProjectGeneratorRequestHandler?) :
    ProjectGeneratorRequestHandler() {
    override fun onHandle(request: String): ProjectGenerator? {
        return if (request == REQUEST) LibraryProjectGenerator(prompter) else null
    }

    companion object {
        const val REQUEST = "library"
    }
}
