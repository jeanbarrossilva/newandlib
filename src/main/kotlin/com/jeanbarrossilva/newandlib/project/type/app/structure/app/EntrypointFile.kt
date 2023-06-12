package com.jeanbarrossilva.newandlib.project.type.app.structure.app

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.project.type.app.entrypoint
import com.jeanbarrossilva.newandlib.project.type.app.theme
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class EntrypointFile(override val parentPath: Path, naming: Naming, `package`: Package) : TextFile() {
    override val name = "${naming.entrypoint}.kt"

    @Suppress("SpellCheckingInspection")
    override val text = """
        package ${`package`.name}.app

        import android.content.res.Configuration
        import androidx.compose.animation.AnimatedContentTransitionScope
        import androidx.compose.animation.ExperimentalAnimationApi
        import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
        import androidx.compose.animation.core.FiniteAnimationSpec
        import androidx.compose.animation.core.animateDpAsState
        import androidx.compose.animation.core.tween
        import androidx.compose.animation.fadeIn
        import androidx.compose.animation.fadeOut
        import androidx.compose.foundation.layout.WindowInsetsSides
        import androidx.compose.foundation.layout.only
        import androidx.compose.material3.BottomAppBar
        import androidx.compose.material3.BottomAppBarDefaults
        import androidx.compose.material3.BottomSheetDefaults
        import androidx.compose.material3.ExperimentalMaterial3Api
        import androidx.compose.material3.Scaffold
        import androidx.compose.material3.ScaffoldDefaults
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.getValue
        import androidx.compose.runtime.remember
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.graphics.Color
        import androidx.compose.ui.tooling.preview.Preview
        import androidx.compose.ui.unit.dp
        import androidx.navigation.plusAssign
        import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
        import com.google.accompanist.navigation.material.ModalBottomSheetLayout
        import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
        import ${`package`.name}.platform.theme.${naming.theme}
        import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
        import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
        import com.ramcosta.composedestinations.utils.currentDestinationAsState

        @Composable
        @OptIn(
            ExperimentalMaterialNavigationApi::class,
            ExperimentalAnimationApi::class,
            ExperimentalMaterial3Api::class
        )
        internal fun ${naming.entrypoint}(modifier: Modifier = Modifier) {
            val engine = rememberAnimatedNavHostEngine(
                rootDefaultAnimations = RootNavGraphDefaultAnimations(
                    enterTransition = {
                        fadeIn(enterTransitionAnimationSpec()) + slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Up,
                            enterTransitionAnimationSpec(),
                            initialOffset = ::transitionOffset
                        )
                    },
                    exitTransition = {
                        fadeOut(exitTransitionAnimationSpec()) + slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Down,
                            exitTransitionAnimationSpec(),
                            targetOffset = ::transitionOffset
                        )
                    }
                )
            )
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController =
                engine.rememberNavController().apply { navigatorProvider += bottomSheetNavigator }
            val destination by navController.currentDestinationAsState()
            val isAtTop = remember(destination) {
                val route = destination?.route
                route == null || '/' !in route
            }
            val onBottomAreaAvailabilityChangeListener =
                remember(::${naming.default}OnBottomAreaAvailabilityChangeListener)
            val bottomBarTonalElevation by animateDpAsState(
                if (onBottomAreaAvailabilityChangeListener.isAvailable) {
                    BottomAppBarDefaults.ContainerElevation
                } else {
                    0.dp
                }
            )

            ${naming.theme} {
                ModalBottomSheetLayout(
                    bottomSheetNavigator,
                    sheetShape = BottomSheetDefaults.ExpandedShape
                ) {
                    @Suppress("UnusedMaterial3ScaffoldPaddingParameter")
                    Scaffold(
                        modifier,
                        bottomBar = {
                            BottomAppBar(tonalElevation = bottomBarTonalElevation) {
                            }
                        },
                        containerColor = Color.Transparent,
                        contentWindowInsets = ScaffoldDefaults
                            .contentWindowInsets
                            .only(WindowInsetsSides.Start)
                            .only(WindowInsetsSides.End)
                            .only(WindowInsetsSides.Bottom)
                    ) {
        //                DestinationsNavHost(
        //                    NavGraphs.root,
        //                    Modifier.padding(padding),
        //                    engine = engine,
        //                    navController = navController,
        //                    dependenciesContainerBuilder = {
        //                        dependency(onBottomAreaAvailabilityChangeListener)
        //                    }
        //                )
                    }
                }
            }
        }

        private fun <T> enterTransitionAnimationSpec(): FiniteAnimationSpec<T> {
            return transitionAnimationSpec()
        }

        private fun <T> exitTransitionAnimationSpec(): FiniteAnimationSpec<T> {
            return transitionAnimationSpec(DefaultDurationMillis / 2)
        }

        private fun <T> transitionAnimationSpec(durationInMillis: Int = DefaultDurationMillis):
            FiniteAnimationSpec<T> {
            return tween(durationInMillis)
        }

        private fun transitionOffset(full: Int): Int {
            return full / 4
        }

        @Composable
        @Preview
        @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
        private fun ${naming.entrypoint}Preview() {
            ${naming.entrypoint}()
        }
    """
}
