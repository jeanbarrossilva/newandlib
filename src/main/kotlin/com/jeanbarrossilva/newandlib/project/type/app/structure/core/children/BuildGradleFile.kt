package com.jeanbarrossilva.newandlib.project.type.app.structure.core.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path) : TextFile() {
    override val name = "build.gradle.kts"
    override val text = """
        plugins {
            id("java-library")
            kotlin("jvm")
        }

        java {
            sourceCompatibility = Versions.java
            targetCompatibility = Versions.java
        }

        dependencies {
            api(Dependencies.COROUTINES_CORE)
        }
    """
}
