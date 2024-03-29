package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.ui.setting.group

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.theme
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class SettingGroupFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "SettingGroup.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.ui.setting.group

        import android.content.res.Configuration
        import androidx.compose.animation.AnimatedVisibility
        import androidx.compose.foundation.layout.Column
        import androidx.compose.material3.Divider
        import androidx.compose.material3.Icon
        import androidx.compose.material3.Switch
        import androidx.compose.material3.Text
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.DisposableEffect
        import androidx.compose.runtime.remember
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.graphics.RectangleShape
        import androidx.compose.ui.tooling.preview.Preview
        import ${project.`package`.name}.platform.theme.${project.naming.theme}
        import ${project.`package`.name}.platform.theme.extensions.forwardsNavigationArrow
        import ${project.`package`.name}.platform.theme.extensions.reversed
        import ${project.`package`.name}.platform.theme.ui.setting.Setting
        import ${project.`package`.name}.platform.theme.ui.setting.SettingDefaults
        
        /**
         * [Setting] that holds various other [Setting]s that are related to it.
         *
         * @param text Primary [Text] of the headline. If the [Setting] has a label, it signals the state
         * it's currently in; otherwise, describes what it's related to.
         * @param action Content that may or may not be interactive that explicits the purpose or the
         * current state of the [Setting].
         * @param isExpanded Whether the [content] is visible.
         * @param modifier [Modifier] to be applied to the underlying [Column].
         * @param content [Setting]s to be added through the given [SettingGroupScope].
         **/
        @Composable
        fun SettingGroup(
            text: @Composable () -> Unit,
            action: @Composable () -> Unit,
            isExpanded: Boolean,
            modifier: Modifier = Modifier,
            content: SettingGroupScope.() -> Unit
        ) {
            val scope = remember(::SettingGroupScope)
        
            DisposableEffect(text as Any?, action as Any?, isExpanded, modifier, content, scope.metadata) {
                scope.content()
                onDispose { }
            }
        
            Column(modifier) {
                Setting(text, action, onClick = null)
        
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Divider()
        
                        scope.metadata.forEachIndexed { index, metadata ->
                            Setting(
                                metadata.text,
                                metadata.action,
                                metadata.onClick,
                                metadata.modifier,
                                shape = if (index == scope.metadata.lastIndex) {
                                    SettingDefaults.shape.reversed
                                } else {
                                    RectangleShape
                                }
                            )
                        }
                    }
                }
            }
        }
        
        /** Preview of a [SettingGroup]. **/
        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun SettingGroupPreview() {
            ${project.naming.theme} {
                SettingGroup(
                    text = { Text("Expand") },
                    isExpanded = true,
                    action = {
                        Switch(checked = true, onCheckedChange = { })
                    }
                ) {
                    repeat(4) { index ->
                        setting(
                            id = "${'$'}index",
                            text = { Text("#${'$'}index") },
                            action = {
                                Icon(
                                    ${project.naming.theme}.Icons.forwardsNavigationArrow,
                                    contentDescription = "Navigate"
                                )
                            },
                            onClick = { }
                        )
                    }
                }
            }
        }
    """
}
