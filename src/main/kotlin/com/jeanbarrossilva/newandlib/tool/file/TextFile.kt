package com.jeanbarrossilva.newandlib.tool.file

import com.jeanbarrossilva.newandlib.tool.extensions.`if`
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.writer

abstract class TextFile : File {
    abstract val directory: Directory
    abstract val name: String
    abstract val text: String

    final override val path: Path
        get() = Path.of("${directory.path}" + java.io.File.pathSeparator + name)

    final override fun create(origin: String) {
        Files.createFile(path)?.writer()?.use {
            val indentTrimmedText = text.trimIndent().`if`(String::isNotEmpty) { plus("\n") }
            it.write(indentTrimmedText)
        }
    }
}
