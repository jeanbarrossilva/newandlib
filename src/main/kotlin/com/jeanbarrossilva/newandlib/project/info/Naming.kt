package com.jeanbarrossilva.newandlib.project.info

import com.google.common.base.CaseFormat

internal class Naming private constructor(val default: String, val hyphenated: String, val lowerCamelCased: String) {
    companion object {
        infix fun from(default: String): Naming {
            val lowerCamelCased = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, default)
            return Naming(default, hyphenated = lowerCamelCased, lowerCamelCased)
        }
    }
}
