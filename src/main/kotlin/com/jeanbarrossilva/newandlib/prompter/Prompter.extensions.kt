package com.jeanbarrossilva.newandlib.prompter

import com.google.common.base.CaseFormat
import com.jeanbarrossilva.newandlib.Prompts
import com.jeanbarrossilva.newandlib.prompter.system.SystemPrompter

/** Hyphenated value input into [Prompts.PROJECT_NAME]. **/
internal val Prompter.hyphenatedProjectName
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, get(Prompts.PROJECT_NAME)!!)

/** Lower-camel-cased value input into [Prompts.PROJECT_NAME].  **/
internal val Prompter.lowerCamelCasedProjectName
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, get(Prompts.PROJECT_NAME)!!)

/**
 * Runs [prompt] with a [SystemPrompter].
 *
 * @param prompt Operations to be made on the [Prompter].
 **/
internal inline fun prompt(prompt: Prompter.() -> Unit) {
    promptWith(SystemPrompter(), prompt)
}

/**
 * Runs [prompt] with the given [prompter].
 *
 * @param prompter [Prompter] with which [prompt] will be run.
 * @param prompt Operations to be made on the [Prompter].
 **/
internal inline fun <T : Prompter> promptWith(prompter: T, prompt: T.() -> Unit) {
    prompter.apply(prompt)
}
