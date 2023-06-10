package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources

import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.values.ThemesNightFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class ValuesNightDirectory(root: Path) : Directory() {
    override val path = root + at("values-night")
    override val children = listOf(ThemesNightFile(root))
}
