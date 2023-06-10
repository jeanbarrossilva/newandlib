package com.jeanbarrossilva.newandlib.project.type.library

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.RepositoryHandlerExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.ModuleDirectory
import com.jeanbarrossilva.newandlib.project.type.library.structure.workflows.PublishingWorkflowFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal class LibraryProjectGenerator(prompter: Prompter) : ProjectGenerator(prompter) {
    override val prompts: List<Prompt>
        get() = super.prompts + RepositoryUrlPrompt()

    override fun onGenerate(project: Project) {
        val repositoryUrl = prompter.require<RepositoryUrlPrompt>()
        ModuleDirectory(project.path, project).write()
        PublishingWorkflowFile(project.path + at(".github") + at("workflows")).write()
        RepositoryHandlerExtensionsFile(
            project.path + at("buildSrc") + at("src") + at("main") + at("java"),
            project.naming,
            repositoryUrl
        )
            .write()
    }
}
