package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.extensions.`if`

internal object ContentFormatter {
    fun format(content: String, default: String?): String {
        return "> $content".`if`(default != null) { plus(" ($default)") } + " "
    }
}
