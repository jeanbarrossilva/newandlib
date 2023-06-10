package com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.MetadataFile
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.PluginsFile
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.VariantsFile
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children.VersionsFile
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class BuildSrcDirectory(root: Path, project: Project) : Directory() {
    override val path: Path = root.resolve("buildSrc")
    override val children = listOf(
        BuildGradleFile(path),
        GitIgnoreFile(path),
        MetadataFile(path.javaMainSource, project),
        PluginsFile(path.javaMainSource),
        VariantsFile(path.javaMainSource),
        VersionsFile(path.javaMainSource, project.naming)
    )
}
