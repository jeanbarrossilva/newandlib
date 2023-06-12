package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.SettingDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class UIDirectory(root: Path, project: Project) : Directory() {
    override val path = root.javaMainSource + at("ui")
    override val children = listOf(SettingDirectory(path, project))
}
