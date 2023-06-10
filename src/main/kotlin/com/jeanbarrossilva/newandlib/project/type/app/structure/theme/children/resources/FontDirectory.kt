package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.NoSuchFileException
import java.nio.file.Path

internal class FontDirectory(root: Path) : Directory() {
    override val path = root + at(NAME)
    override val children = Thread
        .currentThread()
        .contextClassLoader
        .getResource(NAME)
        ?.path
        ?.let(::at)
        ?.map { located(it) }
        ?: throw NoSuchFileException(NAME)

    companion object {
        private const val NAME = "font"
    }
}
