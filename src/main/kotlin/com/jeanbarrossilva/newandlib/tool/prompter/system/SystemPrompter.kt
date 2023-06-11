package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

@PublishedApi
internal class SystemPrompter : Prompter() {
    override fun onPrompt(prompt: Prompt): String? {
        val formattedContent = PromptFormatter.format(prompt)
        print(formattedContent)
        return readlnOrNull()
    }
}
