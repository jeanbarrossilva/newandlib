package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.configuration.OverlaysFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.configuration.SpacingsFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class ConfigurationDirectory(root: Path, project: Project) : Directory() {
    override val path = root.javaMainSource + at("configuration")
    override val children = listOf(OverlaysFile(path, project), SpacingsFile(path, project))
}
