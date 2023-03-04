package com.jeanbarrossilva.newandlib.prompter.system

import com.jeanbarrossilva.newandlib.utils.`if`

internal object QuestionFormatter {
    fun format(question: String, default: String?): String {
        return "> $question".`if`(default != null) { plus(" ($default)") } + " "
    }
}
