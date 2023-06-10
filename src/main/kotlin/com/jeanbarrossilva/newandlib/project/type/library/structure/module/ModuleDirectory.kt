package com.jeanbarrossilva.newandlib.project.type.library.structure.module

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.children.AndroidManifestFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import com.jeanbarrossilva.newandlib.utils.mainSource
import java.nio.file.Path
import kotlin.io.path.createDirectories

internal class ModuleDirectory(root: Path, private val project: Project) : Directory {
    override val path = root + at(project.naming.hyphenated)
    override val children =
        listOf(AndroidManifestFile(path.mainSource), BuildGradleFile(path, project.naming), GitIgnoreFile(path))

    override fun write() {
        super.write()
        path.javaMainSource.resolve(project.`package`.path).createDirectories()
    }
}
