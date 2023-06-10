package com.jeanbarrossilva.newandlib.tool.prompter

import kotlin.reflect.KClass

abstract class Prompter internal constructor() {
    /** [HashMap] whose keys are the [Prompt]s and values are their respective response. **/
    private val prompts = hashMapOf<KClass<out Prompt>, String?>()

    /**
     * Prompts the user the given [prompt].
     *
     * @param prompt [Prompt] to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    fun prompt(prompt: Prompt, default: String? = null): String {
        val response = onPrompt(prompt, default) ?: default ?: prompt(prompt, default)
        prompts[prompt::class] = response
        return response
    }

    /** Gets the response given by the user to the [Prompt] of type [T]. **/
    inline fun <reified T : Prompt> get(): String? {
        return get(T::class)
    }

    /**
     * Gets the response given by the user to the [Prompt] whose [KClass] is equal to [promptClass].
     *
     * @param promptClass [KClass] of the [Prompt] whose response will be obtained.
     **/
    fun <T : Prompt> get(promptClass: KClass<T>): String? {
        return prompts[promptClass]
    }

    /**
     * Gets the response given by the user to the [Prompt] of type [T].
     *
     * @throws IllegalStateException If no input for the [Prompt] has been provided.
     **/
    inline fun <reified T : Prompt> require(): String {
        return require(T::class)
    }

    /**
     * Gets the response given by the user to the [Prompt] whose [KClass] is equal to [promptClass].
     *
     * @param promptClass [KClass] of the [Prompt] whose response will be obtained.
     * @throws IllegalStateException If no input for the [Prompt] has been provided.
     **/
    fun <T : Prompt> require(promptClass: KClass<T>): String {
        return get(promptClass) ?: throw IllegalStateException(
            "No input provided for prompt ${promptClass.simpleName}."
        )
    }

    /**
     * Prompts the user the given [prompt].
     *
     * @param prompt [Prompt] to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    protected abstract fun onPrompt(prompt: Prompt, default: String?): String?
}
