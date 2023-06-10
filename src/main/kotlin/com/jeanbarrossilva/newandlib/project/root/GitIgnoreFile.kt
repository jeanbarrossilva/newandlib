package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class GitIgnoreFile(override val parentPath: Path) : TextFile() {
    override val name = ".gitignore"
    override val text = """
        *.iml
        .gradle
        local.properties
        .idea
        .DS_Store
        build
        /captures
        .externalNativeBuild
        .cxx
        local.properties
    """
}
