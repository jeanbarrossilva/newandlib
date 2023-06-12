package com.jeanbarrossilva.newandlib.project.type.app.structure.theme

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.AndroidManifestFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.ResourcesDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ConfigurationDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ExtensionsDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.ReactivityDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.UIDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.provider.ThemeProviderFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class ThemeModuleDirectory(root: Path, project: Project) : Directory() {
    override val path = root + at("platform") + at("theme")
    override val children = listOf(
        AndroidManifestFile(path),
        BuildGradleFile(path, project.naming),
        ConfigurationDirectory(path, project),
        ExtensionsDirectory(path, project),
        ReactivityDirectory(path, project),
        ResourcesDirectory(path, project.naming),
        ThemeProviderFile(path, project),
        UIDirectory(path, project)
    )
}
