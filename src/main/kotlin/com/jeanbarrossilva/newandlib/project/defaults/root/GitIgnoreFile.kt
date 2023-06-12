package com.jeanbarrossilva.newandlib.project.defaults.root

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class GitIgnoreFile(override val parentPath: Path) : TextFile() {
    override val name = ".gitignore"
    override val text = """
        /.gradle
        /.idea
        /build
        /captures
        *.iml
        .cxx
        .DS_Store
        .externalNativeBuild
        local.properties
    """
}
