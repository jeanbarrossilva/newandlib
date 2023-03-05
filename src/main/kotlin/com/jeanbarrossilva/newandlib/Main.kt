package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.generator.MainGenerator
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
        prompt(
            Prompts.REPOSITORY_URL,
            "What is the URL of the repository to which the project will be uploaded?",
            ""
        )
        MainGenerator(this).generate()
        Runtime.getRuntime().exec("chmod +x gradlew")
        Runtime.getRuntime().exec("studio ${get(Prompts.PROJECT_PATH)}")
        println("Done!")
    }
}
