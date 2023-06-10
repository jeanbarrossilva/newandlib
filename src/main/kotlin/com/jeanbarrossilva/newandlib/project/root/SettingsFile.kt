package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.project.Naming
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class SettingsFile(override val directory: Directory, naming: Naming) : TextFile() {
    override val name = "settings.gradle"
    override val text = """
        rootProject.name = "${naming.default}"
        include(":app", ":${naming.hyphenated}")
    """
}
