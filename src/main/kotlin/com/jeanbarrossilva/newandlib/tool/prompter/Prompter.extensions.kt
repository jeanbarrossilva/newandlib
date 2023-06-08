package com.jeanbarrossilva.newandlib.tool.prompter

import com.jeanbarrossilva.newandlib.tool.prompter.system.SystemPrompter

/**
 * Runs [prompt] with a [SystemPrompter].
 *
 * @param prompt Operations to be made on the [Prompter].
 **/
inline fun prompt(prompt: Prompter.() -> Unit) {
    promptWith(SystemPrompter(), prompt)
}

/**
 * Runs [prompt] with the given [prompter].
 *
 * @param prompter [Prompter] with which [prompt] will be run.
 * @param prompt Operations to be made on the [Prompter].
 **/
inline fun <T : Prompter> promptWith(prompter: T, prompt: T.() -> Unit) {
    prompter.apply(prompt)
}
