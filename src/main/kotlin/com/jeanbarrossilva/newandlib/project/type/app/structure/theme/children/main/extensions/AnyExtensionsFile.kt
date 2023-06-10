package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.extensions

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class AnyExtensionsFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "Any.extensions.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.extensions

        /**
         * Returns the result of the given [transform] if the [condition] is `true`; otherwise, returns the
         * receiver.
         *
         * @param condition Determines whether or not the result of [transform] will get returned.
         * @param transform Transformation to be made to the receiver.
         **/
        internal inline fun <T> T.`if`(condition: Boolean, transform: T.() -> T): T {
            return if (condition) transform() else this
        }
    """
}
