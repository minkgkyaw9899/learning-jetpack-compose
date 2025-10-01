package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
  Column(
    modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .clip(RoundedCornerShape(24.dp))
        .padding(24.dp)
        .background(MaterialTheme.colorScheme.primaryContainer)
        .verticalScroll(rememberScrollState())
  ) {
    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Spacer(modifier = modifier.height(40.dp))

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

    Button(
      modifier = modifier.padding(20.dp),
      onClick = {}) {
      Text(text = "Button 1")
    }

    Button(
      onClick = {}) {
      Text(text = "Button 2")
    }

  }
}
