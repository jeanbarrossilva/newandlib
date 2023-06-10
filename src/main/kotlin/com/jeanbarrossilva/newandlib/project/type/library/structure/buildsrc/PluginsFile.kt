package com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class PluginsFile(override val parentPath: Path) : TextFile() {
    override val name = "Plugins.kt"
    override val text = """
        object Plugins {
            const val GRADLE = "com.android.tools.build:gradle:${'$'}{Versions.GRADLE}"
            const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${'$'}{Versions.KOTLIN}"
        }
    """
}
