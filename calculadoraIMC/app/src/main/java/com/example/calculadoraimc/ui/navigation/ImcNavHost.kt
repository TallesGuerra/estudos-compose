package com.example.calculadoraimc.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculadoraimc.ui.splash.SplashScreen
import com.example.calculadoraimc.ui.history.HistoryScreen
import com.example.calculadoraimc.ui.input.InputScreen
import com.example.calculadoraimc.ui.result.ResultScreen

@Composable
fun ImcNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController =  navController,
        startDestination = ImcRoutes.SPLASH.name,
        modifier = Modifier.fillMaxSize()
    ){
        composable(ImcRoutes.SPLASH.name){
          SplashScreen() {
              navController.navigate(ImcRoutes.INPUT.name)
          }
      }
        composable(ImcRoutes.RESULT.name){
            ResultScreen(){
                navController.navigate(ImcRoutes.INPUT.name)
            }
        }
        composable(ImcRoutes.INPUT.name){
            InputScreen(navController)
        }
        composable(ImcRoutes.HISTORY.name){
            HistoryScreen(){
                navController.navigate(ImcRoutes.SPLASH.name)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ImcNavHostPreview(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

   Text("ImcNavHostPreview")
    }

}

