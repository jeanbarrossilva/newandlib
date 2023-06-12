package com.jeanbarrossilva.newandlib.project.defaults

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.defaults.root.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.defaults.root.GitIgnoreFile
import com.jeanbarrossilva.newandlib.project.defaults.root.GradlePropertiesFile
import com.jeanbarrossilva.newandlib.project.defaults.root.GradleWBatFile
import com.jeanbarrossilva.newandlib.project.defaults.root.GradleWFile
import com.jeanbarrossilva.newandlib.project.defaults.root.LocalPropertiesFile
import com.jeanbarrossilva.newandlib.project.defaults.root.app.AppDirectory
import com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.BuildSrcDirectory
import com.jeanbarrossilva.newandlib.project.defaults.root.gradle.GradleWrapperDirectory
import com.jeanbarrossilva.newandlib.project.defaults.root.workflows.WorkflowsDirectory
import com.jeanbarrossilva.newandlib.tool.file.Directory

internal class RootDirectory(project: Project) : Directory() {
    override val path = project.path
    override val children = listOf(
        AppDirectory(path),
        BuildGradleFile(path),
        BuildSrcDirectory(path, project),
        GitIgnoreFile(path),
        GradlePropertiesFile(path),
        GradleWrapperDirectory(path),
        GradleWBatFile(path),
        GradleWFile(path),
        LocalPropertiesFile(path),
        WorkflowsDirectory(path)
    )
}
