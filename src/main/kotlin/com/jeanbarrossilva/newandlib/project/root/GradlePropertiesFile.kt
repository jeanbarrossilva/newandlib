package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class GradlePropertiesFile(override val parentPath: Path) : TextFile() {
    override val name = "gradle.properties"

    @Suppress("SpellCheckingInspection")
    override val text = """
        org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
        android.useAndroidX=true
        kotlin.code.style=official
        android.nonTransitiveRClass=true
    """
}
