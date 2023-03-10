package com.jeanbarrossilva.newandlib.writer

import com.jeanbarrossilva.newandlib.utils.`if`
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

internal class FileWriter(private val origin: String) {
    fun writeTo(pathValue: String, content: String) {
        val path = absolute(pathValue)
        Files.createDirectories(path.parent)
        val file = Files.createFile(path)
        if (file != null) {
            writeTo(file, content)
        }
    }

    private fun writeTo(file: Path, content: String) {
        val indentTrimmedContent = content.trimIndent().`if`(String::isNotEmpty) { plus("\n") }
        file.toFile().writer().use { it.write(indentTrimmedContent) }
    }

    private fun absolute(relativePathValue: String): Path {
        return Paths.get("$origin/$relativePathValue")
    }
}
