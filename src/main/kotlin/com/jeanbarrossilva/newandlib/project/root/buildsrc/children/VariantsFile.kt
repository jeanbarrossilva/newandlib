package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class VariantsFile(override val parentPath: Path) : TextFile() {
    override val name = "Variants.kt"
    override val text = """
        object Variants {
            const val RELEASE = "release"
        }
    """
}
