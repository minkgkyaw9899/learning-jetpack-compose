package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size
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
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Image(
      painter = painterResource(R.drawable.img1),
      contentDescription = "Sample Image",
      contentScale = ContentScale.Crop,
      modifier = Modifier
          .size(150.dp)
          .clip(CircleShape)
    )

    Spacer(modifier = Modifier.height(50.dp))

    val imgUrl = "https://i.pinimg.com/736x/80/cc/19/80cc19f6f188b037be9f621d4c9bb189.jpg"

    val model = ImageRequest
      .Builder(LocalPlatformContext.current)
      .size(Size.ORIGINAL)
      .data(imgUrl)
      .build()

    val imgPainter = rememberAsyncImagePainter(model = model)

    val imgState = imgPainter.state.collectAsState();

    Spacer(modifier = Modifier.height(50.dp))

    when (imgState.value) {
      AsyncImagePainter.State.Empty -> Text(text = "No Image")
      is AsyncImagePainter.State.Error -> Icon(
        imageVector = Icons.Rounded.Warning,
        contentDescription = null,
        tint = Color.Red,
        modifier = Modifier
            .size(100.dp)
            .width(100.dp)
      )

      is AsyncImagePainter.State.Loading -> CircularProgressIndicator(
        modifier = Modifier.size(100.dp),
        color = Color.Yellow
      )

      is AsyncImagePainter.State.Success -> Image(
        painter = imgPainter,
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(24.dp))
      )
    }

  }
}
