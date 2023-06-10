package com.jeanbarrossilva.newandlib.project.root.gradle.children

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.fileAt
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.File
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import kotlin.io.path.writer

internal class GradleWrapperFile(root: Path) : File {
    override val path = root + at(NAME)

    override fun write() {
        super.write()
        Thread
            .currentThread()
            .contextClassLoader
            .getResourceAsStream(NAME)
            ?.reader()
            ?.readText()
            ?.let { fileAt(path).writer().write(it) }
            ?: throw NoSuchFileException(NAME)
    }

    companion object {
        private const val NAME = "gradle-wrapper.jar"
    }
}
