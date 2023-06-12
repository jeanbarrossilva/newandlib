package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.provider

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.project.type.app.structure.theme.theme
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import com.jeanbarrossilva.newandlib.utils.javaMainSource
import java.nio.file.Path

internal class ThemeProviderFile(parentPath: Path, project: Project) : TextFile() {
    override val parentPath = parentPath.javaMainSource
    override val name = "${project.naming.theme}.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme

        import android.content.res.Configuration
        import androidx.compose.foundation.background
        import androidx.compose.foundation.isSystemInDarkTheme
        import androidx.compose.foundation.layout.Arrangement
        import androidx.compose.foundation.layout.Box
        import androidx.compose.foundation.layout.Column
        import androidx.compose.foundation.layout.ColumnScope
        import androidx.compose.foundation.layout.PaddingValues
        import androidx.compose.foundation.layout.Row
        import androidx.compose.foundation.layout.RowScope
        import androidx.compose.foundation.layout.fillMaxWidth
        import androidx.compose.foundation.layout.height
        import androidx.compose.foundation.layout.padding
        import androidx.compose.foundation.layout.size
        import androidx.compose.material.icons.Icons
        import androidx.compose.material3.ColorScheme
        import androidx.compose.material3.LocalTextStyle
        import androidx.compose.material3.MaterialTheme
        import androidx.compose.material3.Shapes
        import androidx.compose.material3.Surface
        import androidx.compose.material3.Text
        import androidx.compose.material3.Typography
        import androidx.compose.material3.darkColorScheme
        import androidx.compose.material3.lightColorScheme
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.CompositionLocal
        import androidx.compose.runtime.CompositionLocalProvider
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.draw.clip
        import androidx.compose.ui.graphics.Color
        import androidx.compose.ui.graphics.Shape
        import androidx.compose.ui.text.font.FontFamily
        import androidx.compose.ui.text.font.FontWeight
        import androidx.compose.ui.tooling.preview.Preview
        import androidx.compose.ui.unit.Dp
        import androidx.compose.ui.unit.dp
        import androidx.compose.ui.unit.sp
        import ${project.`package`.name}.platform.theme.configuration.LocalOverlays
        import ${project.`package`.name}.platform.theme.configuration.LocalSpacings
        import ${project.`package`.name}.platform.theme.configuration.Overlays
        import ${project.`package`.name}.platform.theme.configuration.Spacings
        import ${project.`package`.name}.platform.theme.extensions.Rubik
        import ${project.`package`.name}.platform.theme.extensions.bottom
        import ${project.`package`.name}.platform.theme.extensions.colorAttribute
        import ${project.`package`.name}.platform.theme.extensions.end
        import ${project.`package`.name}.platform.theme.extensions.start
        import ${project.`package`.name}.platform.theme.extensions.top
        import ${project.`package`.name}.platform.theme.extensions.with

        /** Height of [ColorSchemePreview]. **/
        private const val COLOR_SCHEME_PREVIEW_HEIGHT = 1_884

        /** Height of [ShapesPreview]. **/
        private const val SHAPES_PREVIEW_HEIGHT = 898

        /** Height of [TypographyPreview]. **/
        private const val TYPOGRAPHY_PREVIEW_HEIGHT = 1_130

        /** [ColorScheme] for when the system theme is dark. **/
        private val DarkColorScheme = darkColorScheme()

        /** [ColorScheme] for when the system theme is light. **/
        private val LightColorScheme = lightColorScheme()

        /** [android.R.attr.colorControlNormal] with medium visibility. **/
        private val fadedContentColor
            @Composable get() = colorAttribute(android.R.attr.colorControlNormal).copy(alpha = .5f)

        /** Provider of [${project.naming.theme}]'s configurations. **/
        object ${project.naming.theme} {
            /**
             * [Icons][androidx.compose.material.icons.Icons] in the chosen style. Alias for
             * [Icons.Rounded].
             **/
            val Icons = androidx.compose.material.icons.Icons.Rounded

            /** [Current][CompositionLocal.current] [ColorScheme] from the underlying [MaterialTheme]. **/
            val colorScheme
                @Composable get() = MaterialTheme.colorScheme

            /** [Current][CompositionLocal.current] [Overlays] from [LocalOverlays]. **/
            val overlays
                @Composable get() = LocalOverlays.current

            /** [Current][CompositionLocal.current] [Shapes] from the underlying [MaterialTheme]. **/
            val shapes
                @Composable get() = MaterialTheme.shapes

            /** [Current][CompositionLocal.current] [Spacings] from [LocalSpacings]. **/
            val spacings
                @Composable get() = LocalSpacings.current

            /** [Current][CompositionLocal.current] [Typography] from the underlying [MaterialTheme]. **/
            val typography
                @Composable get() = MaterialTheme.typography
        }

        /**
         * [MaterialTheme] for Tick.
         *
         * @param content Content to be themed.
         **/
        @Composable
        fun ${project.naming.theme}(content: @Composable () -> Unit) {
            MaterialTheme(
                colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme,
                typography = with(Typography() with FontFamily.Rubik) {
                    copy(
                        displayLarge = displayLarge.copy(
                            color = fadedContentColor,
                            fontWeight = FontWeight.Black
                        ),
                        titleLarge = titleLarge.copy(fontWeight = FontWeight.ExtraBold),
                        titleMedium = titleSmall.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                        titleSmall = titleSmall.copy(color = fadedContentColor, fontSize = 18.sp),
                        bodyLarge = bodyLarge.copy(fontWeight = FontWeight.Bold),
                        labelLarge = labelMedium.copy(
                            color = fadedContentColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            ) {
                CompositionLocalProvider(
                    LocalOverlays provides Overlays.Default,
                    LocalSpacings provides Spacings.default,
                    LocalTextStyle provides ${project.naming.theme}.typography.bodyMedium,
                    content = content
                )
            }
        }

        /** Preview of [${project.naming.theme}]'s [ColorScheme]. **/
        @Composable
        @Preview(heightDp = COLOR_SCHEME_PREVIEW_HEIGHT)
        @Preview(heightDp = COLOR_SCHEME_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun ColorSchemePreview() {
            ${project.naming.theme} {
                Column(Modifier.fillMaxWidth()) {
                    ColorSchemeSection("Primary") {
                        Color(${project.naming.theme}.colorScheme.primary)
                        Color(${project.naming.theme}.colorScheme.inversePrimary)
                        Color(${project.naming.theme}.colorScheme.onPrimary)
                    }

                    ColorSchemeSection("Primary container") {
                        Color(${project.naming.theme}.colorScheme.primaryContainer)
                        Color(${project.naming.theme}.colorScheme.onPrimaryContainer)
                    }

                    ColorSchemeSection("Secondary") {
                        Color(${project.naming.theme}.colorScheme.secondary)
                        Color(${project.naming.theme}.colorScheme.onSecondary)
                    }

                    ColorSchemeSection("Secondary container") {
                        Color(${project.naming.theme}.colorScheme.secondaryContainer)
                        Color(${project.naming.theme}.colorScheme.onSecondaryContainer)
                    }

                    ColorSchemeSection("Tertiary") {
                        Color(${project.naming.theme}.colorScheme.tertiary)
                        Color(${project.naming.theme}.colorScheme.onTertiary)
                    }

                    ColorSchemeSection("Tertiary container") {
                        Color(${project.naming.theme}.colorScheme.tertiaryContainer)
                        Color(${project.naming.theme}.colorScheme.onTertiaryContainer)
                    }

                    ColorSchemeSection("Background") {
                        Color(${project.naming.theme}.colorScheme.background)
                        Color(${project.naming.theme}.colorScheme.onBackground)
                    }

                    ColorSchemeSection("Surface") {
                        Color(${project.naming.theme}.colorScheme.surface)
                        Color(${project.naming.theme}.colorScheme.inverseSurface)
                        Color(${project.naming.theme}.colorScheme.onSurface)
                        Color(${project.naming.theme}.colorScheme.inverseOnSurface)
                        Color(${project.naming.theme}.colorScheme.surfaceTint)
                    }

                    ColorSchemeSection("Surface variant") {
                        Color(${project.naming.theme}.colorScheme.surfaceVariant)
                        Color(${project.naming.theme}.colorScheme.onSurfaceVariant)
                    }

                    ColorSchemeSection("Error") {
                        Color(${project.naming.theme}.colorScheme.error)
                        Color(${project.naming.theme}.colorScheme.onError)
                    }

                    ColorSchemeSection("Error container") {
                        Color(${project.naming.theme}.colorScheme.errorContainer)
                        Color(${project.naming.theme}.colorScheme.onErrorContainer)
                    }

                    ColorSchemeSection("Outline") {
                        Color(${project.naming.theme}.colorScheme.outline)
                    }

                    ColorSchemeSection("Outline variant") {
                        Color(${project.naming.theme}.colorScheme.outlineVariant)
                    }

                    ColorSchemeSection("Scrim") {
                        Color(${project.naming.theme}.colorScheme.scrim)
                    }
                }
            }
        }

        /** Preview of [${project.naming.theme}]'s [Overlays]. **/
        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun OverlaysPreview() {
            ${project.naming.theme} {
                Surface(color = ${project.naming.theme}.colorScheme.background) {
                    OverlaySection("FAB", ${project.naming.theme}.overlays.fab)
                }
            }
        }

        /** Preview of [${project.naming.theme}]'s [Shapes]. **/
        @Composable
        @Preview(heightDp = SHAPES_PREVIEW_HEIGHT)
        @Preview(heightDp = SHAPES_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun ShapesPreview() {
            ${project.naming.theme} {
                Surface(Modifier.fillMaxWidth(), color = ${project.naming.theme}.colorScheme.background) {
                    Column {
                        ShapeSection("Extra large", ${project.naming.theme}.shapes.extraLarge)
                        ShapeSection("Large", ${project.naming.theme}.shapes.large)
                        ShapeSection("Medium", ${project.naming.theme}.shapes.medium)
                        ShapeSection("Small", ${project.naming.theme}.shapes.small)
                        ShapeSection("Extra small", ${project.naming.theme}.shapes.extraSmall)
                    }
                }
            }
        }

        /** Preview of [${project.naming.theme}]'s [Spacings]. **/
        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun SpacingsPreview() {
            ${project.naming.theme} {
                Surface(Modifier.fillMaxWidth()) {
                    Column {
                        SpacingSection("Extra large", ${project.naming.theme}.spacings.extraLarge)
                        SpacingSection("Large", ${project.naming.theme}.spacings.large)
                        SpacingSection("Medium", ${project.naming.theme}.spacings.medium)
                        SpacingSection("Small", ${project.naming.theme}.spacings.small)
                        SpacingSection("Extra small", ${project.naming.theme}.spacings.extraSmall)
                    }
                }
            }
        }

        /** Preview of [${project.naming.theme}]'s [Typography]. **/
        @Composable
        @Preview(heightDp = TYPOGRAPHY_PREVIEW_HEIGHT)
        @Preview(heightDp = TYPOGRAPHY_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun TypographyPreview() {
            ${project.naming.theme} {
                Surface(Modifier.fillMaxWidth(), color = ${project.naming.theme}.colorScheme.background) {
                    Column {
                        TypographySection("Display") {
                            Text("D1", style = ${project.naming.theme}.typography.displayLarge)
                            Text("D2", style = ${project.naming.theme}.typography.displayMedium)
                            Text("D3", style = ${project.naming.theme}.typography.displaySmall)
                        }

                        TypographySection("Headline") {
                            Text("H1", style = ${project.naming.theme}.typography.headlineLarge)
                            Text("H2", style = ${project.naming.theme}.typography.headlineMedium)
                            Text("H3", style = ${project.naming.theme}.typography.headlineSmall)
                        }

                        TypographySection("Title") {
                            Text("T1", style = ${project.naming.theme}.typography.titleLarge)
                            Text("T2", style = ${project.naming.theme}.typography.titleMedium)
                            Text("T3", style = ${project.naming.theme}.typography.titleSmall)
                        }

                        TypographySection("Body") {
                            Text("B1", style = ${project.naming.theme}.typography.bodyLarge)
                            Text("B2", style = ${project.naming.theme}.typography.bodyMedium)
                            Text("B3", style = ${project.naming.theme}.typography.bodySmall)
                        }

                        TypographySection("Label") {
                            Text("L1", style = ${project.naming.theme}.typography.labelLarge)
                            Text("L2", style = ${project.naming.theme}.typography.labelMedium)
                            Text("L3", style = ${project.naming.theme}.typography.labelSmall)
                        }
                    }
                }
            }
        }

        /**
         * [Section] that displays the [Color][${project.`package`.name}.platform.theme.Color]s provided in
         * the [content].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param modifier [Modifier] to be applied to the underlying [Section].
         * @param content [Color][${project.`package`.name}.platform.theme.Color]s to be shown.
         **/
        @Composable
        private fun ColorSchemeSection(
            title: String,
            modifier: Modifier = Modifier,
            content: @Composable RowScope.() -> Unit
        ) {
            Section(title, modifier) {
                Row(content = content)
            }
        }

        /**
         * [Box] that displays the given [color].
         *
         * @param color [Color] to be displayed.
         **/
        @Composable
        private fun Color(color: Color) {
            Box(
                Modifier
                    .background(color)
                    .size(64.dp)
            )
        }

        /**
         * [Section] that displays the given [overlay].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param overlay Overlay to be displayed.
         * @param modifier [Modifier] to be applied to the underlying [Section].
         **/
        @Composable
        private fun OverlaySection(title: String, overlay: PaddingValues, modifier: Modifier = Modifier) {
            Section(title, modifier) {
                Text(
                    "[${'$'}{overlay.start}, ${'$'}{overlay.top}, ${'$'}{overlay.end}, ${'$'}{overlay.bottom}]",
                    Modifier.padding(${project.naming.theme}.spacings.large),
                    style = ${project.naming.theme}.typography.titleMedium
                )
            }
        }

        /**
         * [Section] that displays the given [shape].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param shape [Shape] to be displayed.
         * @param modifier [Modifier] to be applied to the underlying [Section].
         **/
        @Composable
        private fun ShapeSection(title: String, shape: Shape, modifier: Modifier = Modifier) {
            Section(title, modifier) {
                Box(
                    Modifier
                        .padding(it)
                        .clip(shape)
                        .background(${project.naming.theme}.colorScheme.primaryContainer)
                        .height(64.dp)
                        .fillMaxWidth()
                )
            }
        }

        /**
         * [Section] that displays the given [spacing].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param spacing Spacing to be displayed.
         * @param modifier [Modifier] to be applied to the underlying [Section].
         **/
        @Composable
        private fun SpacingSection(title: String, spacing: Dp, modifier: Modifier = Modifier) {
            Section(title, modifier) { padding ->
                Text(
                    "${'$'}spacing",
                    Modifier
                        .padding(start = padding.start, top = spacing, end = padding.end, bottom = spacing),
                    style = ${project.naming.theme}.typography.titleMedium
                )
            }
        }

        /**
         * [Section] that displays the [Text]s in the given [content].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param modifier [Modifier] to be applied to the underlying [Section].
         * @param content [Text]s to be shown.
         **/
        @Composable
        private fun TypographySection(
            title: String,
            modifier: Modifier = Modifier,
            content: @Composable ColumnScope.() -> Unit
        ) {
            Section(title, modifier) {
                Column(
                    modifier.padding(it),
                    Arrangement.spacedBy(${project.naming.theme}.spacings.small),
                    content = content
                )
            }
        }

        /**
         * Displays a header with the given [title] followed by the [content].
         *
         * @param title Text to be shown in the header, that explains what's being displayed.
         * @param modifier [Modifier] to be applied to the underlying [Column].
         * @param content Content to be displayed. Receives the same padding that's applied to the header.
         **/
        @Composable
        private fun Section(
            title: String,
            modifier: Modifier = Modifier,
            content: @Composable ColumnScope.(padding: PaddingValues) -> Unit
        ) {
            val padding = PaddingValues(${project.naming.theme}.spacings.large)

            Column(modifier) {
                Text(
                    title,
                    Modifier
                        .background(${project.naming.theme}.colorScheme.surfaceVariant)
                        .padding(padding)
                        .fillMaxWidth(),
                    ${project.naming.theme}.colorScheme.onSurfaceVariant,
                    style = ${project.naming.theme}.typography.titleMedium
                )

                content(padding)
            }
        }
    """
}
