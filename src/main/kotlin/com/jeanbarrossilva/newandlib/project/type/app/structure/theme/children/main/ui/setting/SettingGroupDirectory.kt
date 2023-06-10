package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting.group.SettingGroupFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting.group.SettingGroupScopeFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ui.setting.group.SettingMetadataFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class SettingGroupDirectory(root: Path, project: Project) : Directory() {
    override val path = root + at("group")
    override val children = listOf(
        SettingGroupFile(path, project),
        SettingGroupScopeFile(path, project),
        SettingMetadataFile(path, project)
    )
}
