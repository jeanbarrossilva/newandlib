package com.jeanbarrossilva.newandlib.tool.file

import java.nio.file.Path

interface File {
    val path: Path

    fun create(origin: String)
}
