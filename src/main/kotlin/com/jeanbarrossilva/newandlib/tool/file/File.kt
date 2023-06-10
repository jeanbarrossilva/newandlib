package com.jeanbarrossilva.newandlib.tool.file

import java.nio.file.Files
import java.nio.file.Path

abstract class File {
    protected abstract val path: Path

    open fun write() {
        Files.createDirectories(path.parent)
    }

    companion object {
        fun located(path: Path): File {
            return object : File() {
                override val path = path
            }
        }
    }
}
