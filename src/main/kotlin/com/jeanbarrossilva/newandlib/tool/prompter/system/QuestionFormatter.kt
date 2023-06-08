package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.extensions.`if`

internal object QuestionFormatter {
    fun format(question: String, default: String?): String {
        return "> $question".`if`(default != null) { plus(" ($default)") } + " "
    }
}
