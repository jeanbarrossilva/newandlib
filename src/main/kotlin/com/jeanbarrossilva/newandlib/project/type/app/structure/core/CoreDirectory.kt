package com.jeanbarrossilva.newandlib.project.type.app.structure.core

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.core.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.core.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path
import kotlin.io.path.createDirectories

internal class CoreDirectory(root: Path, private val project: Project) : Directory() {
    override val path = root + at("core").javaMainSource
    override val children = listOf(BuildGradleFile(path), GitIgnoreFile(path))

    override fun onWrite() {
        (path + project.`package`.path).createDirectories()
        (path + at("src") + at("test") + at("java") + project.`package`.path + at("core")).createDirectories()
    }
}
