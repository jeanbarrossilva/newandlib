package com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class VersionsFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "Versions.kt"

    @Suppress("SpellCheckingInspection")
    override val text = """
        import org.gradle.api.JavaVersion

        object Versions {
            const val COMPOSE_COMPILER = "1.4.7"
            const val COMPOSE_DESTINATIONS = "1.9.42-beta"
            const val COMPOSE_MATERIAL_3 = "1.2.0-alpha02"
            const val COMPOSE_UI_TOOLING = "1.4.3"
            const val COROUTINES = "1.7.1"
            const val LOADABLE = "1.5.2"
            const val GRADLE = "8.0.2"
            const val KOTLIN = "1.8.21"
            const val KSP = "1.8.21-1.0.11"
            const val MATERIAL = "1.9.0"
            const val VIEWMODEL = "2.6.1"

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
