package com.jeanbarrossilva.newandlib.project.root.buildsrc

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.MetadataFile
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.PluginsFile
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.VariantsFile
import com.jeanbarrossilva.newandlib.project.root.buildsrc.children.VersionsFile
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class BuildSrcDirectory(root: Path, project: Project) : Directory {
    override val path: Path = root.resolve("buildSrc")
    override val children = listOf(
        BuildGradleFile(this),
        GitIgnoreFile(this),
        MetadataFile(this + path.javaMainSource, project),
        PluginsFile(this + path.javaMainSource),
        VariantsFile(this + path.javaMainSource),
        VersionsFile(this + path.javaMainSource, project.naming)
    )
}
