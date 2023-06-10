package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class VariantsFile(override val directory: Directory) : TextFile() {
    override val name = "Variants.kt"
    override val text = """
        object Variants {
            const val RELEASE = "release"
        }
    """
}
