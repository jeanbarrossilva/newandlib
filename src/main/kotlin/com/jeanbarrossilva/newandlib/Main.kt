package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.project.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.project.type.library.LibraryProjectGenerator
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.tool.prompter.prompt
import java.io.IOException

fun main() {
    prompt {
        val generator = LibraryProjectGenerator(this)

        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        generator.prompts.forEach(::prompt)
        generator.generate()
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
