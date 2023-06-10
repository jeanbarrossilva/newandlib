package com.jeanbarrossilva.newandlib.project

import java.nio.file.Path

internal data class Project(val path: Path, val naming: Naming, val groupID: String, val `package`: Package)
