package com.jeanbarrossilva.newandlib.tool.prompter

abstract class Prompter internal constructor() {
    /** [HashMap] whose keys are the [Prompt]s and values are their respective response. **/
    private val prompts = hashMapOf<Prompt, String?>()

    /**
     * Prompts the user the given [prompt].
     *
     * @param prompt [Prompt] to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    fun prompt(prompt: Prompt, default: String? = null): String {
        val response = onPrompt(prompt, default) ?: default ?: prompt(prompt, default)
        prompts[prompt] = response
        return response
    }

    /**
     * Gets the response given by the user to the [prompt].
     *
     * @param prompt [Prompt] whose response will be obtained.
     **/
    operator fun get(prompt: Prompt): String? {
        return prompts[prompt]
    }

    /**
     * Gets the response given by the user to the [prompt].
     *
     * @throws IllegalStateException If no input for the [prompt] has been provided.
     **/
    fun require(prompt: Prompt): String {
        return get(prompt) ?: throw IllegalStateException("No input provided for prompt ${prompt::class.simpleName}.")
    }

    /**
     * Prompts the user the given [prompt].
     *
     * @param prompt [Prompt] to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    protected abstract fun onPrompt(prompt: Prompt, default: String?): String?
}
