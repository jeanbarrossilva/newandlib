package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.AnyExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.ColorExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.CornerBasedShapeExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.FontFamilyExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.IconsRoundedExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.MutableInteractionSourceExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.PaddingValuesExtensionsFile
import com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions.TypefaceExtensionsFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class ExtensionsDirectory(root: Path, project: Project) : Directory() {
    override val path = root.javaMainSource + at("extensions")
    override val children = listOf(
        AnyExtensionsFile(path, project),
        ColorExtensionsFile(path, project),
        CornerBasedShapeExtensionsFile(path, project),
        FontFamilyExtensionsFile(path, project),
        IconsRoundedExtensionsFile(path, project),
        MutableInteractionSourceExtensionsFile(path, project),
        PaddingValuesExtensionsFile(path, project),
        TypefaceExtensionsFile(path, project)
    )
}
