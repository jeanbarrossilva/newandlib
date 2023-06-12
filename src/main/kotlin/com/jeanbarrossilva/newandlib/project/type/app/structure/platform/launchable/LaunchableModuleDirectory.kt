package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.launchable

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.launchable.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.launchable.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.launchable.children.LaunchableFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

@Suppress("SpellCheckingInspection")
internal class LaunchableModuleDirectory(root: Path, project: Project) : Directory() {
    override val path = root + at("launchable")
    override val children = listOf(
        BuildGradleFile(path, project.naming),
        GitIgnoreFile(path),
        LaunchableFile(path.javaMainSource, project.`package`)
    )
}

