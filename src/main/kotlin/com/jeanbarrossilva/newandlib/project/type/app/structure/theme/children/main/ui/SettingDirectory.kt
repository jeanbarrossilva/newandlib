package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting.SettingFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting.SettingGroupDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class SettingDirectory(root: Path, project: Project) : Directory() {
    override val path = root + at("ui") + at("setting")
    override val children = listOf(SettingFile(path, project), SettingGroupDirectory(path, project))
}
