package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.type.library.prompt.GroupIDPrompt
import com.jeanbarrossilva.newandlib.type.library.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.type.library.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.type.library.prompt.ProjectTypeNamespacePrompt
import com.jeanbarrossilva.newandlib.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.tool.prompter.prompt
import com.jeanbarrossilva.newandlib.utils.currentPath

fun main() {
    prompt {
        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        prompt(ProjectNamePrompt)
        prompt(GroupIDPrompt)
        prompt(ProjectTypeNamespacePrompt, default = get(GroupIDPrompt))
        prompt(ProjectPathPrompt, default = currentPath)
        prompt(RepositoryUrlPrompt, default = "")
        Generator.generate()
        Runtime.getRuntime().exec("chmod +x gradlew")
        Runtime.getRuntime().exec("studio ${get(ProjectPathPrompt)}")
        println("Done!")
    }
}
