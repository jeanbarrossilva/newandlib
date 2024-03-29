package com.jeanbarrossilva.newandlib.project.defaults.root.workflows

import com.jeanbarrossilva.newandlib.project.defaults.root.workflows.children.FormattingWorkflowFile
import com.jeanbarrossilva.newandlib.project.defaults.root.workflows.children.GradleWorkflowFile
import com.jeanbarrossilva.newandlib.project.defaults.root.workflows.children.InstrumentationWorkflowFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class WorkflowsDirectory(root: Path) : Directory() {
    override val path: Path = root + at(".github/workflows")
    override val children =
        listOf(FormattingWorkflowFile(path), GradleWorkflowFile(path), InstrumentationWorkflowFile(path))
}
