package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.project.ProjectFormatter
import com.jeanbarrossilva.newandlib.project.defaults.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.request.ProjectGeneratorRequester
import com.jeanbarrossilva.newandlib.tool.prompter.prompt

fun main() {
    prompt {
        @Suppress("SpellCheckingInspection")
        println("Welcome to newandlib!\n")

        val project = ProjectGeneratorRequester.request(this).generate()
        ProjectFormatter.format(project)
        ProcessBuilder().command("studio", "${get<ProjectPathPrompt>()}").start()
        println("Done!")
    }
}
