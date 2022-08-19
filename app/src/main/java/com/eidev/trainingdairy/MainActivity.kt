package com.eidev.trainingdairy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.eidev.trainingdairy.bottomNavigation.*
import com.eidev.trainingdairy.ui.theme.Orange400
import com.eidev.trainingdairy.ui.theme.Orange600
import com.eidev.trainingdairy.ui.theme.TrainingDairyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenView()
        }
    }

    @Composable
    private fun MainScreenView() {
        TrainingDairyTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

                val navController = rememberNavController()
                Scaffold(
                    topBar = { TopBar(navController = navController, canPop = true, actionBarTitle = "title") },
                    bottomBar = { BottomNavigation(navController = navController) }
                ) {

                    NavigationGraph(navController = navController)
                }


            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Dairy.screen_route) {
        composable(BottomNavItem.Dairy.screen_route) {
            DairyScreen()
        }
        composable(BottomNavItem.Results.screen_route) {
            ResultsScreen()
        }
        composable(BottomNavItem.Exercise.screen_route) {
            ExerciseScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
            SettingsScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Dairy,
        BottomNavItem.Results,
        BottomNavItem.Exercise,
        BottomNavItem.Settings
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 10.sp) },
                selectedContentColor = Orange400,
                unselectedContentColor = Orange400.copy(0.6f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }

}

@Composable
fun TopBar(navController: NavController, canPop: Boolean, actionBarTitle: String) {
    TopAppBar(
        title = { Text(text = actionBarTitle, fontSize = 18.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        navigationIcon = if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingDairyTheme {
        Greeting("Android")
    }
}