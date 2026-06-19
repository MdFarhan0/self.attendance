package `in`.hridayan.driftly.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import `in`.hridayan.driftly.calender.presentation.screens.CalendarScreen
import `in`.hridayan.driftly.home.presentation.screens.HomeScreen
import `in`.hridayan.driftly.settings.presentation.page.about.screens.AboutScreen
import `in`.hridayan.driftly.settings.presentation.page.attendancewrapped.screens.AttendanceWrappedScreen
import `in`.hridayan.driftly.settings.presentation.page.backup.screens.BackupAndRestoreScreen
import `in`.hridayan.driftly.settings.presentation.page.customisation.screens.CustomisationScreen
import `in`.hridayan.driftly.settings.presentation.page.features.screens.FeaturesScreen as FeaturesScreenComposable
import `in`.hridayan.driftly.settings.presentation.page.lookandfeel.screens.DarkThemeScreen
import `in`.hridayan.driftly.settings.presentation.page.lookandfeel.screens.LookAndFeelScreen
import `in`.hridayan.driftly.settings.presentation.page.mainscreen.screen.SettingsScreen
import `in`.hridayan.driftly.settings.presentation.page.notification.screens.NotificationScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController, startDestination = HomeScreen
        ) {
            composable<HomeScreen>(
                exitTransition = {
                    if (targetState.destination.hasRoute<CalendarScreen>()) slideFadeOutToLeft()
                    else sharedAxisXExit()
                },
                popEnterTransition = {
                    if (initialState.destination.hasRoute<CalendarScreen>()) slideFadeInFromLeft()
                    else sharedAxisXPopEnter()
                }
            ) {
                HomeScreen()
            }

            composable<CalendarScreen>(
                enterTransition = { slideFadeInFromRight() },
                popExitTransition = { slideFadeOutToLeft() }
            ) {
                CalendarScreen()
            }

            composable<SettingsScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                SettingsScreen()
            }

            composable<LookAndFeelScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                LookAndFeelScreen()
            }

            composable<CustomisationScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                CustomisationScreen()
            }

            composable<FeaturesScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                FeaturesScreenComposable()
            }

            composable<AttendanceWrappedScreen>(
                enterTransition = { sharedAxisXEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                AttendanceWrappedScreen()
            }

            composable<DarkThemeScreen>(
                enterTransition = { sharedAxisXEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                DarkThemeScreen()
            }


            composable<AboutScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                AboutScreen()
            }

            composable<ChangelogScreen>(
                enterTransition = { sharedAxisXEnter() },
                exitTransition = { sharedAxisXExit() },
                popEnterTransition = { sharedAxisXPopEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                `in`.hridayan.driftly.settings.presentation.page.changelog.screens.ChangelogScreen()
            }







            composable<BackupAndRestoreScreen>(
                enterTransition = { sharedAxisXEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                BackupAndRestoreScreen()
            }

            composable<NotificationScreen>(
                enterTransition = { sharedAxisXEnter() },
                popExitTransition = { sharedAxisXPopExit() }
            ) {
                NotificationScreen()
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
data class CalendarScreen(
    val subjectId: Int, val subject: String
)

@Serializable
object SettingsScreen

@Serializable
object LookAndFeelScreen

@Serializable
object CustomisationScreen

@Serializable
object FeaturesScreen

@Serializable
object AttendanceWrappedScreen

@Serializable
object DarkThemeScreen

@Serializable
object AboutScreen

@Serializable
object ChangelogScreen



@Serializable
object BackupAndRestoreScreen

@Serializable
object NotificationScreen
