package com.jeanbarrossilva.newandlib.tool.file

import com.jeanbarrossilva.newandlib.tool.extensions.plus
import java.nio.file.Files
import java.nio.file.Path

interface Directory : File {
    val children: List<File>

    override fun write() {
        super.write()
        children.forEach(File::write)
    }

    infix operator fun plus(other: Path): Directory {
        return object : Directory {
            override val path = this@Directory.path + other
            override val children = emptyList<File>()
        }
    }
}
