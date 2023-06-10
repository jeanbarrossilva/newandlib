package com.jeanbarrossilva.newandlib.project.defaults.root.gradle

import com.jeanbarrossilva.newandlib.project.defaults.root.gradle.children.GradleWrapperFile
import com.jeanbarrossilva.newandlib.project.defaults.root.gradle.children.GradleWrapperPropertiesFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import java.nio.file.Path

internal class GradleWrapperDirectory(root: Path) : Directory() {
    override val path = root + at("gradle") + at("wrapper")
    override val children = listOf(GradleWrapperFile(path), GradleWrapperPropertiesFile(path))
}
