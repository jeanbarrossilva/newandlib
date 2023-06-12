package com.jeanbarrossilva.samm.platform.theme

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
import com.jeanbarrossilva.samm.platform.theme.configuration.LocalOverlays
import com.jeanbarrossilva.samm.platform.theme.configuration.LocalSpacings
import com.jeanbarrossilva.samm.platform.theme.configuration.Overlays
import com.jeanbarrossilva.samm.platform.theme.configuration.Spacings
import com.jeanbarrossilva.samm.platform.theme.extensions.Rubik
import com.jeanbarrossilva.samm.platform.theme.extensions.bottom
import com.jeanbarrossilva.samm.platform.theme.extensions.colorAttribute
import com.jeanbarrossilva.samm.platform.theme.extensions.end
import com.jeanbarrossilva.samm.platform.theme.extensions.start
import com.jeanbarrossilva.samm.platform.theme.extensions.top
import com.jeanbarrossilva.samm.platform.theme.extensions.with

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

/** Provider of [SammTheme]'s configurations. **/
object SammTheme {
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
fun SammTheme(content: @Composable () -> Unit) {
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
            LocalTextStyle provides SammTheme.typography.bodyMedium,
            content = content
        )
    }
}

/** Preview of [SammTheme]'s [ColorScheme]. **/
@Composable
@Preview(heightDp = COLOR_SCHEME_PREVIEW_HEIGHT)
@Preview(heightDp = COLOR_SCHEME_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun ColorSchemePreview() {
    SammTheme {
        Column(Modifier.fillMaxWidth()) {
            ColorSchemeSection("Primary") {
                Color(SammTheme.colorScheme.primary)
                Color(SammTheme.colorScheme.inversePrimary)
                Color(SammTheme.colorScheme.onPrimary)
            }

            ColorSchemeSection("Primary container") {
                Color(SammTheme.colorScheme.primaryContainer)
                Color(SammTheme.colorScheme.onPrimaryContainer)
            }

            ColorSchemeSection("Secondary") {
                Color(SammTheme.colorScheme.secondary)
                Color(SammTheme.colorScheme.onSecondary)
            }

            ColorSchemeSection("Secondary container") {
                Color(SammTheme.colorScheme.secondaryContainer)
                Color(SammTheme.colorScheme.onSecondaryContainer)
            }

            ColorSchemeSection("Tertiary") {
                Color(SammTheme.colorScheme.tertiary)
                Color(SammTheme.colorScheme.onTertiary)
            }

            ColorSchemeSection("Tertiary container") {
                Color(SammTheme.colorScheme.tertiaryContainer)
                Color(SammTheme.colorScheme.onTertiaryContainer)
            }

            ColorSchemeSection("Background") {
                Color(SammTheme.colorScheme.background)
                Color(SammTheme.colorScheme.onBackground)
            }

            ColorSchemeSection("Surface") {
                Color(SammTheme.colorScheme.surface)
                Color(SammTheme.colorScheme.inverseSurface)
                Color(SammTheme.colorScheme.onSurface)
                Color(SammTheme.colorScheme.inverseOnSurface)
                Color(SammTheme.colorScheme.surfaceTint)
            }

            ColorSchemeSection("Surface variant") {
                Color(SammTheme.colorScheme.surfaceVariant)
                Color(SammTheme.colorScheme.onSurfaceVariant)
            }

            ColorSchemeSection("Error") {
                Color(SammTheme.colorScheme.error)
                Color(SammTheme.colorScheme.onError)
            }

            ColorSchemeSection("Error container") {
                Color(SammTheme.colorScheme.errorContainer)
                Color(SammTheme.colorScheme.onErrorContainer)
            }

            ColorSchemeSection("Outline") {
                Color(SammTheme.colorScheme.outline)
            }

            ColorSchemeSection("Outline variant") {
                Color(SammTheme.colorScheme.outlineVariant)
            }

            ColorSchemeSection("Scrim") {
                Color(SammTheme.colorScheme.scrim)
            }
        }
    }
}

/** Preview of [SammTheme]'s [Overlays]. **/
@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun OverlaysPreview() {
    SammTheme {
        Surface(color = SammTheme.colorScheme.background) {
            OverlaySection("FAB", SammTheme.overlays.fab)
        }
    }
}

/** Preview of [SammTheme]'s [Shapes]. **/
@Composable
@Preview(heightDp = SHAPES_PREVIEW_HEIGHT)
@Preview(heightDp = SHAPES_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun ShapesPreview() {
    SammTheme {
        Surface(Modifier.fillMaxWidth(), color = SammTheme.colorScheme.background) {
            Column {
                ShapeSection("Extra large", SammTheme.shapes.extraLarge)
                ShapeSection("Large", SammTheme.shapes.large)
                ShapeSection("Medium", SammTheme.shapes.medium)
                ShapeSection("Small", SammTheme.shapes.small)
                ShapeSection("Extra small", SammTheme.shapes.extraSmall)
            }
        }
    }
}

/** Preview of [SammTheme]'s [Spacings]. **/
@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SpacingsPreview() {
    SammTheme {
        Surface(Modifier.fillMaxWidth()) {
            Column {
                SpacingSection("Extra large", SammTheme.spacings.extraLarge)
                SpacingSection("Large", SammTheme.spacings.large)
                SpacingSection("Medium", SammTheme.spacings.medium)
                SpacingSection("Small", SammTheme.spacings.small)
                SpacingSection("Extra small", SammTheme.spacings.extraSmall)
            }
        }
    }
}

/** Preview of [SammTheme]'s [Typography]. **/
@Composable
@Preview(heightDp = TYPOGRAPHY_PREVIEW_HEIGHT)
@Preview(heightDp = TYPOGRAPHY_PREVIEW_HEIGHT, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun TypographyPreview() {
    SammTheme {
        Surface(Modifier.fillMaxWidth(), color = SammTheme.colorScheme.background) {
            Column {
                TypographySection("Display") {
                    Text("D1", style = SammTheme.typography.displayLarge)
                    Text("D2", style = SammTheme.typography.displayMedium)
                    Text("D3", style = SammTheme.typography.displaySmall)
                }

                TypographySection("Headline") {
                    Text("H1", style = SammTheme.typography.headlineLarge)
                    Text("H2", style = SammTheme.typography.headlineMedium)
                    Text("H3", style = SammTheme.typography.headlineSmall)
                }

                TypographySection("Title") {
                    Text("T1", style = SammTheme.typography.titleLarge)
                    Text("T2", style = SammTheme.typography.titleMedium)
                    Text("T3", style = SammTheme.typography.titleSmall)
                }

                TypographySection("Body") {
                    Text("B1", style = SammTheme.typography.bodyLarge)
                    Text("B2", style = SammTheme.typography.bodyMedium)
                    Text("B3", style = SammTheme.typography.bodySmall)
                }

                TypographySection("Label") {
                    Text("L1", style = SammTheme.typography.labelLarge)
                    Text("L2", style = SammTheme.typography.labelMedium)
                    Text("L3", style = SammTheme.typography.labelSmall)
                }
            }
        }
    }
}

/**
 * [Section] that displays the [Color][com.jeanbarrossilva.samm.platform.theme.Color]s provided in
 * the [content].
 *
 * @param title Text to be shown in the header, that explains what's being displayed.
 * @param modifier [Modifier] to be applied to the underlying [Section].
 * @param content [Color][com.jeanbarrossilva.samm.platform.theme.Color]s to be shown.
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
            "[${overlay.start}, ${overlay.top}, ${overlay.end}, ${overlay.bottom}]",
            Modifier.padding(SammTheme.spacings.large),
            style = SammTheme.typography.titleMedium
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
                .background(SammTheme.colorScheme.primaryContainer)
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
            "$spacing",
            Modifier
                .padding(start = padding.start, top = spacing, end = padding.end, bottom = spacing),
            style = SammTheme.typography.titleMedium
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
            Arrangement.spacedBy(SammTheme.spacings.small),
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
    val padding = PaddingValues(SammTheme.spacings.large)

    Column(modifier) {
        Text(
            title,
            Modifier
                .background(SammTheme.colorScheme.surfaceVariant)
                .padding(padding)
                .fillMaxWidth(),
            SammTheme.colorScheme.onSurfaceVariant,
            style = SammTheme.typography.titleMedium
        )

        content(padding)
    }
}
