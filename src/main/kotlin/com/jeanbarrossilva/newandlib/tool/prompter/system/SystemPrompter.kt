package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

@PublishedApi
internal class SystemPrompter : Prompter() {
    override fun onPrompt(message: String): String? {
        print(message)
        return readlnOrNull()
    }
}
