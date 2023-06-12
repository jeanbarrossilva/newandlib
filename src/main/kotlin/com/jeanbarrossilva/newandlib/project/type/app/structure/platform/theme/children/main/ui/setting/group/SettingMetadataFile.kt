package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.ui.setting.group

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class SettingMetadataFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "SettingMetadata.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.ui.setting.group

        import androidx.compose.material3.Text
        import androidx.compose.runtime.Composable
        import androidx.compose.ui.Modifier
        import ${project.`package`.name}.platform.theme.ui.setting.Setting
        import java.util.Objects

        /**
         * Structure that holds the parameters of a [Setting].
         *
         * @param id [String] that uniquely identifies this [SettingMetadata].
         * @param modifier [Modifier] to applied to the [Setting].
         * @param text [Text] to be shown by the [Setting].
         * @param action Action representation to be shown by the [Setting].
         * @param onClick Callback to be run when the [Setting] is clicked.
         **/
        internal data class SettingMetadata(
            val id: String,
            val modifier: Modifier,
            val text: @Composable () -> Unit,
            val action: @Composable () -> Unit,
            val onClick: (() -> Unit)?
        ) {
            override fun equals(other: Any?): Boolean {
                return other is SettingMetadata && id == other.id
            }

            override fun hashCode(): Int {
                return Objects.hash(id, modifier, text, action, onClick)
            }
        }
    """
}
