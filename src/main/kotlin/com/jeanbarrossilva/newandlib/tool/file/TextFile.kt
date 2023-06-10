package com.jeanbarrossilva.newandlib.tool.file

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.fileAt
import com.jeanbarrossilva.newandlib.tool.extensions.`if`
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import java.nio.file.Path

abstract class TextFile : File() {
    protected abstract val parentPath: Path
    protected abstract val name: String
    protected abstract val text: String

    final override val path: Path
        get() = parentPath + at(name)

    final override fun write() {
        super.write()
        fileAt(path).writer().use {
            val indentTrimmedText = text.trimIndent().`if`(String::isNotEmpty) { plus("\n") }
            it.write(indentTrimmedText)
        }
    }
}
