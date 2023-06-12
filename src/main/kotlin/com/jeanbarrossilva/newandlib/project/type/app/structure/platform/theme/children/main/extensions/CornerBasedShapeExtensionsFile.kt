package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class CornerBasedShapeExtensionsFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "CornerBasedShape.extensions.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.extensions

        import androidx.compose.foundation.shape.CornerBasedShape
        import androidx.compose.foundation.shape.CornerSize
        import androidx.compose.foundation.shape.RoundedCornerShape

        /** Reversed version of this [CornerBasedShape], with its top and bottom [CornerSize]s switched. **/
        internal val CornerBasedShape.reversed: CornerBasedShape
            get() = RoundedCornerShape(
                topStart = bottomStart,
                topEnd = bottomEnd,
                bottomEnd = topStart,
                bottomStart = topStart
            )
    """
}
