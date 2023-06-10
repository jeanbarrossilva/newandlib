package com.jeanbarrossilva.newandlib.project.defaults.root.buildsrc.children

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class MetadataFile(override val parentPath: Path, project: Project) :
    TextFile() {
    override val name = "Metadata.kt"
    override val text = """
        object Metadata {
            const val GROUP = "${project.groupID}"
            const val ARTIFACT = "${project.naming.hyphenated}"
            const val NAMESPACE = GROUP

            fun namespace(suffix: String): String {
                return "${'$'}NAMESPACE.${'$'}suffix"
            }
        }
    """
}
