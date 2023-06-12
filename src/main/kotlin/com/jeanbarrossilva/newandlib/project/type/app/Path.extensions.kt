package com.jeanbarrossilva.newandlib.project.type.app

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import java.nio.file.Path

/** [Path] originating from this one in which the app package is located.  **/
internal val Path.app
    get() = this + at("app")
