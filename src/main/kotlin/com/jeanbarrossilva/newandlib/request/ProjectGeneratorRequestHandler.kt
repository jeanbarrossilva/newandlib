package com.jeanbarrossilva.newandlib.request

import com.jeanbarrossilva.newandlib.project.ProjectGenerator

internal abstract class ProjectGeneratorRequestHandler {
    protected abstract val next: ProjectGeneratorRequestHandler?

    fun handle(request: String): ProjectGenerator {
        return onHandle(request) ?: next?.handle(request) ?: throw IllegalStateException(
            "No project generator matching \"$request\" found."
        )
    }

    protected abstract fun onHandle(request: String): ProjectGenerator?
}
