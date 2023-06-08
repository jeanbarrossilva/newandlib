package com.jeanbarrossilva.newandlib.tool.prompter

import com.google.common.base.CaseFormat
import com.jeanbarrossilva.newandlib.Prompts
import com.jeanbarrossilva.newandlib.tool.prompter.system.SystemPrompter

/** Whether we've been provided a repository URL. **/
val Prompter.hasRepositoryUrl
    get() = get(Prompts.REPOSITORY_URL)!!.isNotBlank()

/** Hyphenated value input into [Prompts.PROJECT_NAME]. **/
val Prompter.hyphenatedProjectName: String
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, get(Prompts.PROJECT_NAME)!!)

/** Lower-camel-cased value input into [Prompts.PROJECT_NAME].  **/
val Prompter.lowerCamelCasedProjectName: String
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, get(Prompts.PROJECT_NAME)!!)

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
