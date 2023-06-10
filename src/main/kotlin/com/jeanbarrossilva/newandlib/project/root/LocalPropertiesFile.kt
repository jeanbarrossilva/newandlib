package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class LocalPropertiesFile(override val parentPath: Path) : TextFile() {
    override val name = "local.properties"
    override val text = "sdk.dir=/Users/${System.getProperty("user.name")}/Library/Android/sdk"
}
