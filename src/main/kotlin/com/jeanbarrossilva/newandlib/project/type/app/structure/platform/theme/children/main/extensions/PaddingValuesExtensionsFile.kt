package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.extensions

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class PaddingValuesExtensionsFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "PaddingValues.extensions.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.extensions

        import androidx.compose.foundation.layout.PaddingValues
        import androidx.compose.foundation.layout.calculateEndPadding
        import androidx.compose.foundation.layout.calculateStartPadding
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.platform.LocalLayoutDirection

        /** Alias for calling [PaddingValues.calculateBottomPadding]. **/
        internal val PaddingValues.bottom
            get() = calculateBottomPadding()

        /** End padding calculated through the [LocalLayoutDirection]. **/
        internal val PaddingValues.end
            @Composable get() = calculateEndPadding(LocalLayoutDirection.current)

        /** Start padding calculated through the [LocalLayoutDirection]. **/
        internal val PaddingValues.start
            @Composable get() = calculateStartPadding(LocalLayoutDirection.current)

        /** Alias for calling [PaddingValues.calculateTopPadding]. **/
        internal val PaddingValues.top
            get() = calculateTopPadding()

        /**
         * Adds the [PaddingValues].
         *
         * @param other [PaddingValues] to add to the receiver one.
         **/
        @Composable
        operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
            return PaddingValues(
                start + other.start,
                calculateTopPadding() + other.calculateTopPadding(),
                end + other.end,
                calculateBottomPadding() + other.calculateBottomPadding()
            )
        }
    """
}
