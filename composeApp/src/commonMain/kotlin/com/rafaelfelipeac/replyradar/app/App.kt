package com.rafaelfelipeac.replyradar.app

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.app.Route.ReplyGraph
import com.rafaelfelipeac.replyradar.app.Route.ReplyList
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenRoot
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = ReplyGraph
        ) {
            navigation<ReplyGraph>(
                startDestination = ReplyList
            ) {
                composable<ReplyList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val viewModel = koinViewModel<ReplyListViewModel>()

                    ReplyListScreenRoot(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
