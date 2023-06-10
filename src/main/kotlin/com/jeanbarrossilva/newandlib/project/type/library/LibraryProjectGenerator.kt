package com.jeanbarrossilva.newandlib.project.type.library

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.ProjectGenerator
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.project.type.library.structure.app.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.PluginsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.RepositoryHandlerExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc.VersionsFile
import com.jeanbarrossilva.newandlib.project.type.library.structure.module.ModuleDirectory
import com.jeanbarrossilva.newandlib.project.type.library.structure.workflows.PublishingWorkflowFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.prompter.Prompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter
import com.jeanbarrossilva.newandlib.utils.javaMainSource

internal class LibraryProjectGenerator(prompter: Prompter) : ProjectGenerator(prompter, typeName = "library") {
    override val prompts: List<Prompt>
        get() = super.prompts + RepositoryUrlPrompt()

    override fun onGenerate(project: Project) {
        val repositoryUrl = prompter.require<RepositoryUrlPrompt>()
        BuildGradleFile(project.path + at("app"), project.naming).write()
        ModuleDirectory(project.path, project).write()
        PluginsFile(project.path).write()
        PublishingWorkflowFile(project.path + at(".github") + at("workflows")).write()
        RepositoryHandlerExtensionsFile(project.path + at("buildSrc").javaMainSource, project.naming, repositoryUrl)
            .write()
        VersionsFile(project.path, project.naming)
    }
}
