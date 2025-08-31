package legalbot.compose.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import legalbot.compose.app.presentation.ComposeApp

@Composable
fun WebApp(onAllNavHostsReady: @Composable (List<NavHostController>) -> Unit) {
    ComposeApp(onAllNavHostsReady = onAllNavHostsReady)
}