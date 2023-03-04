package com.jeanbarrossilva.newandlib.prompter.system

import com.jeanbarrossilva.newandlib.prompter.Prompter

internal class SystemPrompter : Prompter() {
    override fun onPrompt(key: String, prompt: String, default: String?): String? {
        val formattedQuestion = QuestionFormatter.format(prompt, default)
        print(formattedQuestion)
        return readLine()
    }
}
