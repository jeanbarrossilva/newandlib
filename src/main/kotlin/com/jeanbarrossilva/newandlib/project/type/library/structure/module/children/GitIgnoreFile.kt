package com.jeanbarrossilva.newandlib.project.type.library.structure.module.children

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class GitIgnoreFile(override val directory: Directory) : TextFile() {
    override val name = ".gitignore"
    override val text = "/build"
}
