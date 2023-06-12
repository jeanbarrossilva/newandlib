package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

@PublishedApi
internal class SystemPrompter : Prompter() {
    override fun onPrompt(content: String): String? {
        print(content)
        return readlnOrNull()
    }
}
