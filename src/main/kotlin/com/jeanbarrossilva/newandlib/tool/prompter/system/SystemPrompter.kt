package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

@PublishedApi
internal class SystemPrompter : Prompter() {
    override fun onPrompt(prompt: Prompt): String? {
        val formattedContent = ContentFormatter.format(prompt.content, prompt.default)
        print(formattedContent)
        return readlnOrNull()
    }
}
