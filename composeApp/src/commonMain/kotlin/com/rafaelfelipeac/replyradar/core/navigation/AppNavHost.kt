package com.rafaelfelipeac.replyradar.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rafaelfelipeac.replyradar.core.navigation.NavigationAnimation.enter
import com.rafaelfelipeac.replyradar.core.navigation.NavigationAnimation.exit
import com.rafaelfelipeac.replyradar.core.navigation.NavigationAnimation.popEnter
import com.rafaelfelipeac.replyradar.core.navigation.NavigationAnimation.popExit
import com.rafaelfelipeac.replyradar.core.navigation.Route.ActivityLog
import com.rafaelfelipeac.replyradar.core.navigation.Route.ReplyGraph
import com.rafaelfelipeac.replyradar.core.navigation.Route.ReplyList
import com.rafaelfelipeac.replyradar.core.navigation.Route.Settings
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogScreen
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogViewModel
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenRoot
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsScreen
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ReplyGraph
    ) {
        navigation<ReplyGraph>(
            startDestination = ReplyList
        ) {
            composable<ReplyList>(
                enterTransition = { enter() },
                popEnterTransition = { popEnter() }
            ) {
                val viewModel = koinViewModel<ReplyListViewModel>()

                ReplyListScreenRoot(
                    viewModel = viewModel,
                    onSettingsClick = { navController.navigate(Settings) },
                    onActivityLogClick = { navController.navigate(ActivityLog) }
                )
            }

            composable<Settings>(
                enterTransition = { enter() },
                exitTransition = { exit() },
                popEnterTransition = { popEnter() },
                popExitTransition = { popExit() }
            ) {
                val viewModel = koinViewModel<SettingsViewModel>()

                SettingsScreen(
                    viewModel = viewModel,
                    onBackClick = { navController.popBackStack() },
                    onActivityLogClick = { navController.navigate(ActivityLog) }
                )
            }

            composable<ActivityLog>(
                enterTransition = { enter() },
                exitTransition = { exit() },
                popEnterTransition = { popEnter() },
                popExitTransition = { popExit() }
            ) {
                val viewModel = koinViewModel<ActivityLogViewModel>()

                ActivityLogScreen(
                    viewModel = viewModel,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
