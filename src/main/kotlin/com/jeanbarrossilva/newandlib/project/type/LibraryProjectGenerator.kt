package com.jeanbarrossilva.newandlib.project.type

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.RootDirectory
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.RepositoryHandlerExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.ModuleDirectory
import com.jeanbarrossilva.newandlib.project.type.library.structure.workflows.PublishingWorkflowFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class LibraryProjectGenerator : ProjectGenerator() {
    override fun onGenerate(prompter: Prompter, project: Project, root: RootDirectory) {
        val repositoryUrl =
            prompter[RepositoryUrlPrompt] ?: throw IllegalStateException("Repository URL cannot be null.")
        ModuleDirectory(root.path, project).write()
        PublishingWorkflowFile(root + at(".github") + at("workflows")).write()
        RepositoryHandlerExtensionsFile(
            root + at("buildSrc") + at("src") + at("main") + at("java"),
            project.naming,
            repositoryUrl
        )
            .write()
    }
}
