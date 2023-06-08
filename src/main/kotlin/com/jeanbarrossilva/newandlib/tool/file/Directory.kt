package com.jeanbarrossilva.newandlib.tool.file

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

interface Directory : File {
    override fun create(origin: String) {
        val path: Path = Paths.get("$origin/$path")
        Files.createDirectories(path.parent)
    }
}
