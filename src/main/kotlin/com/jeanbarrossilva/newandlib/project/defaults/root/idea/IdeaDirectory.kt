package com.jeanbarrossilva.newandlib.project.defaults.root.idea

import com.jeanbarrossilva.newandlib.project.defaults.root.idea.children.KtlintFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class IdeaDirectory(root: Path) : Directory() {
    override val path = root + at(".idea")
    override val children = listOf(KtlintFile(path))
}
