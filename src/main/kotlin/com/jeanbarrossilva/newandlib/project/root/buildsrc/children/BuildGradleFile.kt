package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path) : TextFile() {
    override val name = "build.gradle.kts"
    override val text = """
        plugins {
            `kotlin-dsl`
        }

        repositories {
            mavenCentral()
        }
    """
}
