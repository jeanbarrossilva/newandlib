package com.jeanbarrossilva.newandlib.tool.extensions

import java.io.File
import java.nio.file.Files
import java.nio.file.Path

/**
 * Gets the existing [File] at [path] or creates a new one if it doesn't exist.
 *
 * @param path [Path] at which the [File] is located.
 **/
internal fun fileAt(path: Path): File {
    val file = path.toFile()
    return if (file.isFile) file else Files.createFile(path).toFile()
}
