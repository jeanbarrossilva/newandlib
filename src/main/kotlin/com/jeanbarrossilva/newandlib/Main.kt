package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.project.type.LibraryProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.library.prompt.GroupIDPrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectTypeNamespacePrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.tool.prompter.prompt
import com.jeanbarrossilva.newandlib.utils.currentPath
import java.io.IOException

fun main() {
    prompt {
        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        prompt(ProjectNamePrompt)
        prompt(GroupIDPrompt)
        prompt(ProjectTypeNamespacePrompt, default = get(GroupIDPrompt))
        prompt(ProjectPathPrompt, default = currentPath)
        prompt(RepositoryUrlPrompt, default = "")
        LibraryProjectGenerator().generate(this)
        ProcessBuilder().run { command("chmod", "+x", "gradlew") }.also(::tryToOpenAndroidStudio)
        println("Done!")
    }
}

private fun Prompter.tryToOpenAndroidStudio(processBuilder: ProcessBuilder) {
    try {
        processBuilder.command("studio", "${get(ProjectPathPrompt)}")
    } catch (_: IOException) {
    }
}
