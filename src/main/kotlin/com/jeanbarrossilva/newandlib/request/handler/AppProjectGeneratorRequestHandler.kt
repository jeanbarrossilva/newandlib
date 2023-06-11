package com.jeanbarrossilva.newandlib.request.handler

import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.app.AppProjectGenerator
import com.jeanbarrossilva.newandlib.request.ProjectGeneratorRequestHandler
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class AppProjectGeneratorRequestHandler(
    private val prompter: Prompter,
    override val next: ProjectGeneratorRequestHandler?
) : ProjectGeneratorRequestHandler() {
    override fun onHandle(request: String): ProjectGenerator? {
        return if (request == REQUEST) AppProjectGenerator(prompter) else null
    }

    companion object {
        const val REQUEST = "app"
    }
}
