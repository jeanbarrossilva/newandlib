package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.extensions

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class MutableInteractionSourceExtensionsFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "MutableInteractionSource.extensions.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.extensions

        import androidx.compose.foundation.interaction.Interaction
        import androidx.compose.foundation.interaction.MutableInteractionSource
        import kotlinx.coroutines.flow.emptyFlow

        /** [MutableInteractionSource] that doesn't emit the [Interaction]s that are sent to it. **/
        @Suppress("FunctionName")
        internal fun EmptyMutableInteractionSource(): MutableInteractionSource {
            return object : MutableInteractionSource {
                override val interactions = emptyFlow<Interaction>()

                override suspend fun emit(interaction: Interaction) {
                }

                override fun tryEmit(interaction: Interaction): Boolean {
                    return false
                }
            }
        }
    """
}
