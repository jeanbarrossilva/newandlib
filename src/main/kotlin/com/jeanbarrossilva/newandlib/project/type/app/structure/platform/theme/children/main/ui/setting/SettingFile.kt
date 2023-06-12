package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.main.ui.setting

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.theme
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class SettingFile(override val parentPath: Path, project: Project) : TextFile() {
    override val name = "Setting.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.ui.setting

        import android.content.res.Configuration
        import androidx.compose.foundation.interaction.MutableInteractionSource
        import androidx.compose.foundation.layout.Arrangement
        import androidx.compose.foundation.layout.Column
        import androidx.compose.foundation.layout.PaddingValues
        import androidx.compose.foundation.layout.Row
        import androidx.compose.foundation.layout.Spacer
        import androidx.compose.foundation.layout.fillMaxWidth
        import androidx.compose.foundation.layout.width
        import androidx.compose.foundation.shape.CornerBasedShape
        import androidx.compose.material3.Button
        import androidx.compose.material3.ButtonDefaults
        import androidx.compose.material3.Icon
        import androidx.compose.material3.LocalTextStyle
        import androidx.compose.material3.ProvideTextStyle
        import androidx.compose.material3.Text
        import androidx.compose.material3.TextFieldDefaults
        import androidx.compose.material3.contentColorFor
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.remember
        import androidx.compose.ui.Alignment
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.graphics.Color
        import androidx.compose.ui.graphics.Shape
        import androidx.compose.ui.text.font.FontWeight
        import androidx.compose.ui.tooling.preview.Preview
        import ${project.`package`.name}.platform.theme.${project.naming.theme}
        import ${project.`package`.name}.platform.theme.extensions.EmptyMutableInteractionSource
        import ${project.`package`.name}.platform.theme.extensions.forwardsNavigationArrow
        import ${project.`package`.name}.platform.theme.extensions.`if`

        /** Default values of a [Setting]. **/
        internal object SettingDefaults {
            /** [Shape] by which a [Setting] is clipped by default. **/
            val shape
                @Composable get() = TextFieldDefaults.shape as CornerBasedShape
        }

        /**
         * Represents configuration that can be made by the user.
         *
         * @param text Secondary [Text] of the headline if the [Setting] has a [label]; otherwise, it's the
         * primary one.
         * @param action Content that may or may not be interactive that explicits the purpose or the
         * current state of the [Setting].
         * @param onClick Lambda to be run whenever a click occurs. The [Setting] becomes non-clickable if
         * it's `null`.
         * @param modifier [Modifier] to be applied to the underlying [Button].
         * @param shape [Shape] by which the [Setting] is clipped.
         * @param label Primary [Text] of the headline. Being `null` hands that role to the [text].
         **/
        @Composable
        fun Setting(
            text: @Composable () -> Unit,
            action: @Composable () -> Unit,
            onClick: (() -> Unit)?,
            modifier: Modifier = Modifier,
            containerColor: Color = ${project.naming.theme}.colorScheme.surfaceVariant,
            label: (@Composable () -> Unit)? = null,
            shape: Shape = SettingDefaults.shape
        ) {
            val contentColor = contentColorFor(containerColor)
            val interactionSource = remember(onClick) {
                onClick?.let { MutableInteractionSource() } ?: EmptyMutableInteractionSource()
            }
            val textStyle = LocalTextStyle.current

            Button(
                onClick ?: { },
                modifier,
                shape = shape,
                colors = ButtonDefaults.buttonColors(containerColor, contentColor),
                contentPadding = PaddingValues(${project.naming.theme}.spacings.medium),
                interactionSource = interactionSource
            ) {
                ProvideTextStyle(textStyle.copy(color = contentColor)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        Arrangement.SpaceBetween,
                        Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(${project.naming.theme}.spacings.extraSmall)) {
                            ProvideTextStyle(
                                LocalTextStyle.current.`if`(label != null) {
                                    copy(fontWeight = FontWeight.Medium)
                                }
                            ) {
                                label?.invoke()
                            }

                            ProvideTextStyle(
                                LocalTextStyle.current.`if`(label != null) { copy(color = contentColor) },
                                text
                            )
                        }

                        Spacer(Modifier.width(${project.naming.theme}.spacings.medium))
                        action()
                    }
                }
            }
        }

        /** Preview of an unlabeled [Setting]. **/
        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun UnlabeledSettingPreview() {
            ${project.naming.theme} {
                Setting(label = null)
            }
        }

        /** Preview of a labeled [Setting]. **/
        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun LabeledSettingPreview() {
            ${project.naming.theme} {
                Setting(label = { Text("Label") })
            }
        }

        /**
         * Sample, no-op [Setting].
         *
         * @param modifier [Modifier] to be applied to the underlying [Setting].
         **/
        @Composable
        private fun Setting(label: (@Composable () -> Unit)?, modifier: Modifier = Modifier) {
            Setting(
                text = { Text("Setting") },
                action = { Icon(${project.naming.theme}.Icons.forwardsNavigationArrow, contentDescription = "Navigate") },
                onClick = { },
                modifier,
                label = label
            )
        }
    """
}
