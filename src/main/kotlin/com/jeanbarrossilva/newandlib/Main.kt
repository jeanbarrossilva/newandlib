package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.project.defaults.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.request.ProjectGeneratorRequester
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.tool.prompter.prompt
import java.io.IOException

fun main() {
    prompt {
        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        ProjectGeneratorRequester.request(this).generate()
        ProcessBuilder().run { command("chmod", "+x", "gradlew") }.also(::tryToOpenAndroidStudio)
        println("Done!")
    }
}

private fun Prompter.tryToOpenAndroidStudio(processBuilder: ProcessBuilder) {
    try {
        processBuilder.command("studio", "${get<ProjectPathPrompt>()}")
    } catch (_: IOException) {
    }
}
