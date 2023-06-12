package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.File
import java.nio.file.Path
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.OnErrorResult
import kotlin.io.path.copyToRecursively

internal class FontFile(root: Path) : File() {
    override val path = root + at(NAME)

    override fun write() {
        super.write()

        @OptIn(ExperimentalPathApi::class)
        Thread.currentThread().contextClassLoader.getResource(NAME)?.path?.let(::at)?.copyToRecursively(
            path,
            onError = { _, _, _ -> OnErrorResult.TERMINATE },
            followLinks = true
        )
    }

    companion object {
        private const val NAME = "font"
    }
}
