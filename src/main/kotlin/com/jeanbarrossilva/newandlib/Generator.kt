package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.project.Naming
import com.jeanbarrossilva.newandlib.project.Package
import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.RootDirectory
import com.jeanbarrossilva.newandlib.project.type.library.prompt.GroupIDPrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.RepositoryHandlerExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.ModuleDirectory
import com.jeanbarrossilva.newandlib.project.type.library.structure.workflows.PublishingWorkflowFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal object Generator {
    context(Prompter)
    fun generate() {
        val pathValue = get(ProjectPathPrompt) ?: throw IllegalStateException("Project path cannot be null.")
        val path = at(pathValue)
        val projectName = get(ProjectNamePrompt) ?: throw IllegalStateException("Project name cannot be null.")
        val naming = Naming from projectName
        val groupID = get(GroupIDPrompt) ?: throw IllegalStateException("Group ID cannot be null.")
        val packageName = get(GroupIDPrompt) ?: throw IllegalStateException("Group ID cannot be null.")
        val repositoryUrl = get(RepositoryUrlPrompt) ?: throw IllegalStateException("Repository URL cannot be null.")
        val project = Project(path, naming, groupID, Package named packageName)
        val rootDirectory = RootDirectory(project)
        rootDirectory.write()
        ModuleDirectory(rootDirectory.path, project).write()
        PublishingWorkflowFile(rootDirectory + at(".github") + at("workflows")).write()
        RepositoryHandlerExtensionsFile(
            rootDirectory + at("buildSrc") + at("src") + at("main") + at("java"),
            naming,
            repositoryUrl
        )
                .write()
    }
}
