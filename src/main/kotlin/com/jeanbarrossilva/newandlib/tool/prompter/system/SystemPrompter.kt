package com.jeanbarrossilva.newandlib.tool.prompter.system

import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

@PublishedApi
internal class SystemPrompter : Prompter() {
    override fun onPrompt(key: String, prompt: String, default: String?): String? {
        val formattedQuestion = QuestionFormatter.format(prompt, default)
        print(formattedQuestion)
        return readlnOrNull()
    }
}
