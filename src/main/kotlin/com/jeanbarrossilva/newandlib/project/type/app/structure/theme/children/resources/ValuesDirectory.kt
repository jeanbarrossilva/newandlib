package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.values.ThemesFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class ValuesDirectory(root: Path, naming: Naming) : Directory() {
    override val path = root + at("values")
    override val children = listOf(ThemesFile(path, naming))
}
