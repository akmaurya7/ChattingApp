package com.example.chattingapp.Navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chattingapp.Screens.ChatListScreen
import com.example.chattingapp.LCViewModel
import com.example.chattingapp.Screens.LogInScreen
import com.example.chattingapp.Screens.ProfileScreen
import com.example.chattingapp.Screens.SignUpScreen
import com.example.chattingapp.Screens.SingleChatScreen
import com.example.chattingapp.Screens.StatusScreen

@Composable
fun ChatAppNavigation() {
    val navController = rememberNavController()
    var vm = hiltViewModel<LCViewModel>()

    NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route) {
        composable(DestinationScreen.Login.route) {
            LogInScreen(navController,vm)
        }

        composable(DestinationScreen.SignUp.route) {
            SignUpScreen(navController,vm)
        }

        composable(DestinationScreen.ChatList.route) {
            ChatListScreen(navController,vm)
        }

        composable(DestinationScreen.SingleChat.route) {
            val chatId = it.arguments?.getString("chatId")
            chatId?.let{
                SingleChatScreen(navController,vm,chatId)
            }
        }

        composable(DestinationScreen.StatusList.route) {
            StatusScreen(navController,vm)
        }

        composable(DestinationScreen.Profile.route) {
            ProfileScreen(navController,vm)
        }
    }
}
