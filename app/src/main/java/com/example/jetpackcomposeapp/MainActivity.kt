package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      JetpackComposeAppTheme {
        Screen()
      }
    }
  }
}

@Composable
@Preview
fun Screen() {
  val textVisibleState = remember {
    mutableStateOf(true)
  }

  val textState = remember {
    mutableStateOf("")
  }

  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    var textInput by remember {
      mutableStateOf("")
    }
    val textInput2 = TextFieldState(initialText = "")
    TextField(
      value = textInput,
      onValueChange = { newText ->
        textInput = newText
      }
    )

    Spacer(modifier = Modifier.height(32.dp))

    TextField(
      value = textInput,
      onValueChange = {
        textInput = it
      },
      label = {
        Text(text = "Search")
      },
      placeholder = {
        Text(text = "Search here...")
      },
      leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
      }
    )

    Spacer(modifier = Modifier.height(32.dp))

    BasicTextField(
//      value = textInput,
//      onValueChange = {
//        textInput = it
//      },
      state = textInput2,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 40.dp)
        .clip(RoundedCornerShape(50.dp))
        .background(MaterialTheme.colorScheme.primaryContainer)
        .padding(16.dp),
      cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
//      maxLines = 1,
//      singleLine = true,
      textStyle = TextStyle(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 18.sp,
      ),
    )

  }
}
