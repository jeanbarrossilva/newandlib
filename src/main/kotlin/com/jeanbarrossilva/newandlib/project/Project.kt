package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import java.nio.file.Path

internal data class Project(val path: Path, val naming: Naming, val groupID: String, val `package`: Package)
