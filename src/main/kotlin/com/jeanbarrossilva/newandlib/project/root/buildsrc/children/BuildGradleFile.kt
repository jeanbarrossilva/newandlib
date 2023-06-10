package com.jeanbarrossilva.newandlib.project.root.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class BuildGradleFile(override val directory: Directory) : TextFile() {
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
