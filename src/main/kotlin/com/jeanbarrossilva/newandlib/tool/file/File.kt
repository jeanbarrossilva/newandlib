package com.jeanbarrossilva.newandlib.tool.file

import java.nio.file.Files
import java.nio.file.Path

interface File {
    val path: Path

    fun write() {
        Files.createDirectories(path.parent)
    }
}
