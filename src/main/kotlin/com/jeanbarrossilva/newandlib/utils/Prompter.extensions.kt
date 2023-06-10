package com.jeanbarrossilva.newandlib.utils

import com.google.common.base.CaseFormat
import com.jeanbarrossilva.newandlib.Prompts
import com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt
import com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt
import com.jeanbarrossilva.newandlib.tool.prompter.Prompter

/** Whether we've been provided a repository URL. **/
val Prompter.hasRepositoryUrl
    get() = get(com.jeanbarrossilva.newandlib.project.type.library.prompt.RepositoryUrlPrompt)!!.isNotBlank()

/** Hyphenated value input into [Prompts.PROJECT_NAME]. **/
val Prompter.hyphenatedProjectName: String
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, get(com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt)!!)

/** Lower-camel-cased value input into [Prompts.PROJECT_NAME].  **/
val Prompter.lowerCamelCasedProjectName: String
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, get(com.jeanbarrossilva.newandlib.project.type.library.prompt.ProjectNamePrompt)!!)
