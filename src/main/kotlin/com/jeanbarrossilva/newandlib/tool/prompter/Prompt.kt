package com.jeanbarrossilva.newandlib.tool.prompter

import com.jeanbarrossilva.newandlib.tool.extensions.`if`

/** Message to be displayed to the user that can be responded by them. **/
abstract class Prompt {
    /** Message to be shown, indicating what input the user should respond with. **/
    protected abstract val message: String

    /** Formatted version of the [message] that displays the available [options] (if any) and the [default] value. **/
    internal val formattedMessage
        get() = "> $message"
            .`if`(options.isNotEmpty()) { plus(" $options") }
            .`if`(default != null) { plus(" ($default)") }
            .plus(" ")

    /** The input that's taken into consideration by default whenever the user ignores this [Prompt]. **/
    open val default: String? = null

    /** Inputs that the user is constrained to respond with. If empty, then anything they hand in is acceptable. **/
    open val options = emptyList<String>()

    /**
     * Whether the [input] is valid.
     *
     * @param input User's response to this [Prompt].
     **/
    internal fun isValid(input: String): Boolean {
        return options.isEmpty() || input in options
    }
}
