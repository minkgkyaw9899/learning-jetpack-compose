package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      JetpackComposeAppTheme {
        Scaffold { innerPadding ->
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          ) {
            itemsIndexed(
              listOf<String>(
                "This",
                "is",
                "Jetpack",
                "Compose",
                "items",
                "indexed",
                "2",
                "This",
                "is",
                "Jetpack",
                "Compose",
                "items",
                "indexed",
                "3",
                "This",
                "is",
                "Jetpack",
                "Compose",
                "items",
                "indexed"
              )
            ) { index, string ->
              Text(
                text = string,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 24.dp, horizontal = 24.dp)
              )
            }
//            items(5000) {
//              Text(
//                text = "Item $it",
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                  .fillMaxWidth()
//                  .padding(vertical = 24.dp, horizontal = 24.dp)
//              )
//            }
          }
        }
      }
    }
  }
}
