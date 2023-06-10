package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class MetadataFile(override val directory: Directory, project: Project) :
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
