package com.jeanbarrossilva.newandlib.project.type.app

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.DependenciesFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.PluginsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.VersionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.core.CoreDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.ThemeModuleDirectory
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class AppProjectGenerator(prompter: Prompter) : ProjectGenerator(prompter, typeName = "app") {
    override fun onGenerate(project: Project) {
        BuildGradleFile(project.path, project.naming).write()
        CoreDirectory(project.path, project).write()
        DependenciesFile(project.path).write()
        PluginsFile(project.path).write()
        ThemeModuleDirectory(project.path, project)
        VersionsFile(project.path, project.naming).write()
    }
}
