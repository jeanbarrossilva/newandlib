package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.project.root.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.root.GitIgnoreFile
import com.jeanbarrossilva.newandlib.project.root.GradlePropertiesFile
import com.jeanbarrossilva.newandlib.project.root.GradleWBatFile
import com.jeanbarrossilva.newandlib.project.root.GradleWFile
import com.jeanbarrossilva.newandlib.project.root.LocalPropertiesFile
import com.jeanbarrossilva.newandlib.project.root.SettingsFile
import com.jeanbarrossilva.newandlib.project.root.app.AppDirectory
import com.jeanbarrossilva.newandlib.project.root.buildsrc.BuildSrcDirectory
import com.jeanbarrossilva.newandlib.project.root.gradle.GradleWrapperDirectory
import com.jeanbarrossilva.newandlib.project.root.workflows.WorkflowsDirectory
import com.jeanbarrossilva.newandlib.tool.file.Directory

internal class RootDirectory(project: Project) : Directory {
    override val path = project.path
    override val children = listOf(
        AppDirectory(path, project.naming),
        BuildGradleFile(path),
        BuildSrcDirectory(path, project),
        GitIgnoreFile(path),
        GradlePropertiesFile(path),
        GradleWrapperDirectory(path),
        GradleWBatFile(path),
        GradleWFile(path),
        LocalPropertiesFile(path),
        SettingsFile(path, project.naming),
        WorkflowsDirectory(path)
    )
}
