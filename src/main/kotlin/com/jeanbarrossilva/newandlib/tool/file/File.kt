package com.jeanbarrossilva.newandlib.tool.file

import java.nio.file.Files
import java.nio.file.Path

abstract class File {
    protected abstract val path: Path

    open fun write() {
        path.parent?.let(Files::createDirectories)
    }

    companion object {
        fun located(path: Path): File {
            return object : File() {
                override val path = path
            }
        }
    }
}
