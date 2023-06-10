package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.project.Naming
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class VersionsFile(override val directory: Directory, naming: Naming) : TextFile() {
    override val name = "Versions.kt"
    override val text = """
        import org.gradle.api.JavaVersion

        object Versions {
            const val GRADLE = "8.0.2"
            const val KOTLIN = "1.8.21"

            val java = JavaVersion.VERSION_17

            object ${naming.default} {
                const val CODE = 1
                const val NAME = "1.0.0"
                const val SDK_COMPILE = 33
                const val SDK_MIN = 21
                const val SDK_TARGET = SDK_COMPILE
            }
        }
    """
}
