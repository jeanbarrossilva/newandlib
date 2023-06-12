package com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children.DependenciesFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children.PluginsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children.VersionsFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class BuildSrcDirectory(root: Path, naming: Naming) : Directory() {
    override val path = root + at("buildSrc")
    override val children = listOf(
        DependenciesFile(path.javaMainSource),
        PluginsFile(path.javaMainSource),
        VersionsFile(path.javaMainSource, naming)
    )
}
