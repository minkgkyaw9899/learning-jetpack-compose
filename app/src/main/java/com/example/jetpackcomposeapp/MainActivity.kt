package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      JetpackComposeAppTheme {
        var selectedNavItem by remember {
          mutableIntStateOf(0)
        }
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          bottomBar = {
            NavigationBar {
              bottomNavItems.forEachIndexed { index, item ->
                NavigationBarItem(
                  selected = index == selectedNavItem,
                  onClick = {
                    selectedNavItem = index
//                    navController.navigate(item.route)
                  },
                  icon = {
                    BadgedBox(
                      badge = {
                        if (item.badges != 0) {
                          Badge {
                            Text(text = item.badges.toString())
                          }
                        } else if (item.hasNews) {
                          Badge()
                        }
                      }
                    ) {
                      Icon(
                        imageVector = if (index == selectedNavItem) {
                          item.selectedIcon
                        } else {
                          item.unselectedIcon
                        },
                        contentDescription = item.title
                      )
                    }
                  },
                  label = {
                    Text(text = item.title)
                  }
                )
              }
            }
          }
        ) {
          it
        }
//        Screen()
      }
    }
  }
}

data class BottomNavItem(
  val title: String,
  val route: String,
  val selectedIcon: ImageVector,
  val unselectedIcon: ImageVector,
  val badges: Int = 0,
  val hasNews: Boolean = false
)

val bottomNavItems = listOf<BottomNavItem>(
  BottomNavItem(
    title = "Home",
    route = "home",
    selectedIcon = Icons.Filled.Home,
    unselectedIcon = Icons.Outlined.Home,
    badges = 0,
    hasNews = false
  ),
  BottomNavItem(
    title = "Posts",
    route = "posts",
    selectedIcon = Icons.Filled.Category,
    unselectedIcon = Icons.Outlined.Category,
    badges = 0,
    hasNews = false
  ),
  BottomNavItem(
    title = "Notifications",
    route = "notifications",
    selectedIcon = Icons.Filled.Notifications,
    unselectedIcon = Icons.Outlined.Notifications,
    badges = 5,
    hasNews = true
  ),
  BottomNavItem(
    title = "Profile",
    route = "profile",
    selectedIcon = Icons.Filled.AccountCircle,
    unselectedIcon = Icons.Outlined.AccountCircle,
    badges = 0,
    hasNews = true
  ),
)
