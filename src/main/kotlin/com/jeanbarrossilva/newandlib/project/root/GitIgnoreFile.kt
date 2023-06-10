package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class GitIgnoreFile(override val directory: Directory) : TextFile() {
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
