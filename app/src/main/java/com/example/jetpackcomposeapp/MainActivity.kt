package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      JetpackComposeAppTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          content = { innerPadding ->
            FirstUi(modifier = Modifier.padding(innerPadding))
          })
      }
    }
  }
}

@Composable
@Preview
fun FirstUi(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primaryContainer)
  ) {
    Button(
      modifier = modifier.align(Alignment.BottomCenter),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      modifier = modifier.align(Alignment.TopCenter),
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.align(Alignment.Center),
      onClick = {}) {
      Text(text = "Button 3")
    }
  }
}
