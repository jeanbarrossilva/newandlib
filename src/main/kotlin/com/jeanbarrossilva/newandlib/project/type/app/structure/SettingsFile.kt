package com.jeanbarrossilva.newandlib.project.type.app.structure

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class SettingsFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "settings.gradle.kts"
    override val text = """
        rootProject.name = "${naming.default}"
        include(":app", ":core", ":platform:theme")
    """
}
