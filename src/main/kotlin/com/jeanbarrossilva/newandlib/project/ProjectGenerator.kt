package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.project.prompt.GroupIDPrompt
import com.jeanbarrossilva.newandlib.project.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.project.prompt.ProjectTypeNamespacePrompt
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal abstract class ProjectGenerator(protected val prompter: Prompter) {
    open val prompts =
        listOf(ProjectNamePrompt(), GroupIDPrompt(), ProjectTypeNamespacePrompt(prompter), ProjectPathPrompt())

    fun generate() {
        val pathValue = prompter.require<ProjectPathPrompt>()
        val path = at(pathValue)
        val projectName = prompter.require<ProjectNamePrompt>()
        val naming = Naming from projectName
        val groupID = prompter.require<GroupIDPrompt>()
        val project = Project(path, naming, groupID, Package named groupID)
        onGenerate(project)
    }

    protected abstract fun onGenerate(project: Project)
}
