package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.project.defaults.RootDirectory
import com.jeanbarrossilva.newandlib.project.defaults.prompt.PackageNamePrompt
import com.jeanbarrossilva.newandlib.project.defaults.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.defaults.prompt.ProjectPathPrompt
import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

internal abstract class ProjectGenerator(protected val prompter: Prompter, typeName: String) {
    protected open val prompts = listOf(ProjectNamePrompt(), PackageNamePrompt(typeName), ProjectPathPrompt())

    fun generate(): Project {
        prompts.forEach(prompter::prompt)
        val pathValue = prompter.require<ProjectPathPrompt>()
        val path = at(pathValue)
        val projectName = prompter.require<ProjectNamePrompt>()
        val naming = Naming from projectName
        val groupID = prompter.require<PackageNamePrompt>()
        val project = Project(path, naming, groupID, Package named groupID)
        RootDirectory(project).write()
        onGenerate(project)
        return project
    }

    protected abstract fun onGenerate(project: Project)
}
