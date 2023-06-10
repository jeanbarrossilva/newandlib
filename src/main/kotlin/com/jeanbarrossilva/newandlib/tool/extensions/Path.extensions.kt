package com.jeanbarrossilva.newandlib.tool.extensions

import java.nio.file.Path

/**
 * Resolves [other] against this [Path]. Shorthand for [resolve].
 *
 * @param other [Path] to be resolved.
 **/
operator fun Path.plus(other: Path): Path {
    return resolve(other)
}

/**
 * Creates a [Path] with the given [value][pathValue].
 *
 * @param pathValue Path [String] to create the [Path] with.
 **/
fun at(pathValue: String): Path {
    return Path.of(pathValue)
}
