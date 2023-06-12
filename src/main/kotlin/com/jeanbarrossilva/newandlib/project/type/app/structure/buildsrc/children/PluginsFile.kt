package com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class PluginsFile(override val parentPath: Path) : TextFile() {
    override val name = "Plugins.kt"

    @Suppress("SpellCheckingInspection")
    override val text = """
        object Plugins {
            @Suppress("SpellCheckingInspection")
            const val COMPOSE_DESTINATIONS =
                "io.github.raamcosta.compose-destinations:ksp:${'$'}{Versions.COMPOSE_DESTINATIONS}"

            const val GRADLE = "com.android.tools.build:gradle:${'$'}{Versions.GRADLE}"
            const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${'$'}{Versions.KOTLIN}"
        }
    """
}
