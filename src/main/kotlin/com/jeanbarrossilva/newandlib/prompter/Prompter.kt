package com.jeanbarrossilva.newandlib.prompter

internal abstract class Prompter {
    /** [HashMap] whose keys are the prompts' keys and values are their response. **/
    private val prompts = hashMapOf<String, Any?>()

    /**
     * Prompts the user the given [prompt].
     *
     * @param key Identifies the response that the user gives for later retrieval.
     * @param prompt Message to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    fun prompt(key: String, prompt: String, default: String? = null): String {
        val response = onPrompt(key, prompt, default) ?: default ?: prompt(key, prompt, default)
        prompts[key] = response
        return response
    }

    /**
     * Gets the response given by the user to a prompt with the same key as [key].
     *
     * @param key Key of the prompt whose response will be obtained.
     **/
    fun get(key: String): String? {
        return get<String>(key)
    }

    /**
     * Gets the response given by the user to a prompt with the same key as [key].
     *
     * @param key Key of the prompt whose response will be obtained.
     **/
    @Suppress("UNCHECKED_CAST")
    operator fun <T> get(key: String): T? {
        return prompts[key] as? T?
    }

    /**
     * Prompts the user the given [prompt].
     *
     * @param key Identifies the response that the user gives for later retrieval.
     * @param prompt Message to be shown to the user.
     * @param default Response that's attached to this prompt by default.
     **/
    protected abstract fun onPrompt(key: String, prompt: String, default: String?): String?
}
