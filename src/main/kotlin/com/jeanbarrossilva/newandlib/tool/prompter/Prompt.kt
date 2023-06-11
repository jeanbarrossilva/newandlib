package com.jeanbarrossilva.newandlib.tool.prompter

/** Message to be displayed to the user that can be responded by them. **/
abstract class Prompt {
    /** The input that's taken into consideration by default whenever the user ignores this [Prompt]. **/
    open val default: String? = null

    /** Inputs that the user is constrained to respond with. If empty, then anything they hand in is acceptable. **/
    open val options = emptyList<String>()

    /** Message to be shown, indicating what input the user should respond with. **/
    abstract val content: String

    /**
     * Receives the [input].
     *
     * @param input User's response to this [Prompt].
     * @param onFailure Callback run if the receipt fails, returning a new input.
     * @return A valid input.
     * @see isValid
     **/
    internal fun receive(input: String, onFailure: () -> String): String {
        return if (isValid(input)) input else onFailure()
    }

    /**
     * Whether the [input] is valid.
     *
     * @param input User's response to this [Prompt].
     **/
    private fun isValid(input: String): Boolean {
        return options.isEmpty() || input in options
    }
}
