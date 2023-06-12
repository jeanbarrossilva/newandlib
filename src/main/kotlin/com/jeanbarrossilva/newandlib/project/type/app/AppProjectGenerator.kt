package com.jeanbarrossilva.newandlib.project.type.app

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.app.structure.SettingsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.ActivityFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.ApplicationFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.EntrypointFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.app.OnBottomAreaAvailabilityChangeListenerImplementationFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.BuildSrcDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children.VersionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.core.CoreDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.PlatformDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import kotlin.io.path.createDirectories

internal class AppProjectGenerator(prompter: Prompter) : ProjectGenerator(prompter, typeName = "app") {
    override fun onGenerate(project: Project) {
        (project.path.app.javaMainSource + project.`package`.path.app).createDirectories()
        ActivityFile(project.path.app.javaMainSource + project.`package`.path.app, project.naming, project.`package`)
            .write()
        ApplicationFile(project.path.app.javaMainSource + project.`package`.path.app, project).write()
        BuildGradleFile(project.path.app, project.naming).write()
        BuildSrcDirectory(project.path, project.naming).write()
        CoreDirectory(project.path, project).write()
        EntrypointFile(project.path.app.javaMainSource + project.`package`.path.app, project.naming, project.`package`)
            .write()
        OnBottomAreaAvailabilityChangeListenerImplementationFile(
            project.path.app.javaMainSource + project.`package`.path.app,
            project.naming,
            project.`package`
        )
            .write()
        SettingsFile(project.path, project.naming).write()
        PlatformDirectory(project.path, project).write()
        VersionsFile(project.path, project.naming).write()
    }
}
