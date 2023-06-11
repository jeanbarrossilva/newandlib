package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.extensions.`if`
import com.jeanbarrossilva.newandlib.tool.prompter.Prompt

internal object PromptFormatter {
    fun format(prompt: Prompt): String {
        return "> ${prompt.content}"
            .`if`(prompt.options.isNotEmpty()) { plus(" ${prompt.options}") }
            .`if`(prompt.default != null) { plus(" (${prompt.default})") }
            .plus(" ")
    }
}
