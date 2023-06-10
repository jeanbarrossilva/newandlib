package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.project.type.library.prompt.GroupIDPrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal abstract class ProjectGenerator {
    fun generate(prompter: Prompter) {
        val pathValue = prompter[ProjectPathPrompt] ?: throw IllegalStateException("Project path cannot be null.")
        val path = at(pathValue)
        val projectName = prompter[ProjectNamePrompt] ?: throw IllegalStateException("Project name cannot be null.")
        val naming = Naming from projectName
        val groupID = prompter[GroupIDPrompt] ?: throw IllegalStateException("Group ID cannot be null.")
        val packageName = prompter[GroupIDPrompt] ?: throw IllegalStateException("Group ID cannot be null.")
        val project = Project(path, naming, groupID, Package named packageName)
        val root = RootDirectory(project).also(RootDirectory::write)
        onGenerate(prompter, project, root)
    }

    protected abstract fun onGenerate(prompter: Prompter, project: Project, root: RootDirectory)
}
