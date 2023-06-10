package com.jeanbarrossilva.newandlib.project.root.app.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class GitIgnoreFile(override val parentPath: Path) : TextFile() {
    override val name = ".gitignore"
    override val text = "/build"
}
