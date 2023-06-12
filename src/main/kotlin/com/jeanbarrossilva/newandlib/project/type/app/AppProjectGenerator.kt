package com.jeanbarrossilva.newandlib.project.type.app

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.app.structure.SettingsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.BuildSrcDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children.VersionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.core.CoreDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.ThemeModuleDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import kotlin.io.path.createDirectories

internal class AppProjectGenerator(prompter: Prompter) : ProjectGenerator(prompter, typeName = "app") {
    override fun onGenerate(project: Project) {
        (project.path + at("app").javaMainSource + project.`package`.path + at("app")).createDirectories()
        BuildGradleFile(project.path + at("app"), project.naming).write()
        BuildSrcDirectory(project.path, project.naming).write()
        CoreDirectory(project.path, project).write()
        SettingsFile(project.path, project.naming).write()
        ThemeModuleDirectory(project.path, project).write()
        VersionsFile(project.path, project.naming).write()
    }
}
