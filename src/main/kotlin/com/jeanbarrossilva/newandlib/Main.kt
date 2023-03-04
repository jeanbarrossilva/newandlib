package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.prompter.prompt
import com.jeanbarrossilva.newandlib.utils.currentPath

fun main() {
    prompt {
        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        prompt(Prompts.PROJECT_NAME, "What's the name of the project?")
        prompt(Prompts.GROUP_ID, "What's the group ID?")
        prompt(
            Prompts.LIBRARY_MODULE_NAMESPACE,
            "What's the namespace of the library module?",
            get(Prompts.GROUP_ID)
        )
        prompt(Prompts.PROJECT_PATH, "Where would you like the project to be created?", currentPath)
        Generator.generate()
        Runtime.getRuntime().exec("studio ${get(Prompts.PROJECT_PATH)}")
        println("Done!")
    }
}
