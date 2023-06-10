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
        val pathValue = prompter.require<ProjectPathPrompt>()
        val path = at(pathValue)
        val projectName = prompter.require<ProjectNamePrompt>()
        val naming = Naming from projectName
        val groupID = prompter.require<GroupIDPrompt>()
        val project = Project(path, naming, groupID, Package named groupID)
        onGenerate(prompter, project)
    }

    protected abstract fun onGenerate(prompter: Prompter, project: Project)
}
