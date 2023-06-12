package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.reactivity.OnBottomAreaAvailabilityChangeListenerFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class ReactivityDirectory(root: Path, project: Project) : Directory() {
    override val path = root.javaMainSource + at("reactivity")
    override val children = listOf(OnBottomAreaAvailabilityChangeListenerFile(path, project))
}
