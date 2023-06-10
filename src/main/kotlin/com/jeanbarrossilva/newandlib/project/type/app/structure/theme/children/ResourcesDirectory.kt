package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.FontDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.ValuesDirectory
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.ValuesNightDirectory
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.mainSource
import java.nio.file.Path

internal class ResourcesDirectory(root: Path, naming: Naming) : Directory() {
    override val path = root.mainSource + at("res")
    override val children = listOf(FontDirectory(path), ValuesDirectory(path, naming), ValuesNightDirectory(path))
}
