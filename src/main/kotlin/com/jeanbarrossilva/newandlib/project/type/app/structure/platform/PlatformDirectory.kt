package com.jeanbarrossilva.newandlib.project.type.app.structure.platform

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.launchable.LaunchableModuleDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.ThemeModuleDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class PlatformDirectory(root: Path, project: Project) : Directory() {
    override val path = root + at("platform")
    override val children = listOf(LaunchableModuleDirectory(path, project), ThemeModuleDirectory(path, project))
}
