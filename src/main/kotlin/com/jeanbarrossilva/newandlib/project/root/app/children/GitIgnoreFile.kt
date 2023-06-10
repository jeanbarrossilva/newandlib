package com.jeanbarrossilva.newandlib.project.root.app.children

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class GitIgnoreFile(override val directory: Directory) : TextFile() {
    override val name = ".gitignore"
    override val text = "/build"
}
