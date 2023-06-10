package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class LocalPropertiesFile(override val directory: Directory) : TextFile() {
    override val name = "local.properties"
    override val text = "sdk.dir=/Users/${System.getProperty("user.name")}/Library/Android/sdk"
}
