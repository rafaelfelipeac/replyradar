package com.rafaelfelipeac.replyradar.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.app.navigation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        AppNavHost(navController = navController)
    }
}

/*
MVP (v1)
- readme
- create History/User Actions database for V1?
- unit tests
