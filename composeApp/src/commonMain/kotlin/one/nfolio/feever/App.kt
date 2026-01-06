package one.nfolio.feever

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import feever.composeapp.generated.resources.Res
import feever.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
  /*
  MaterialTheme {
    var showContent by remember { mutableStateOf(false) }
    Column(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .safeContentPadding()
        .fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Button(onClick = { showContent = !showContent }) {
        Text("Click me!")
      }
      AnimatedVisibility(showContent) {
        val greeting = remember { Greeting().greet() }
        Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Image(painterResource(Res.drawable.compose_multiplatform), null)
          Text("Compose: $greeting")
        }
      }
    }
  }
  */

  MaterialTheme {
    Column(
      modifier = Modifier
        .safeDrawingPadding()
        .fillMaxSize()
        .background(Color.LightGray)
    ) {

      Column(
        modifier = Modifier
          .background(
            color = Color.White,
            shape = RoundedCornerShape(
              bottomStart = 10.dp,
              bottomEnd = 10.dp
            )
          )
      ) { // header

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
          // .border(width = 2.dp, color = Color.Black)
        ) {
          Text("Header")
        }

        Row {
          val feedNames = remember {
            TestFeedConfigurator.getAllName()
          }

          feedNames.forEach { feedBName ->
            Text(
              text = feedBName,
              modifier = Modifier
                .drawBehind {
                  drawLine(
                    color = Color.Red,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                  )
                }
                .padding(start = 0.dp)
            )
          }
        }
      }

      Column {
        Row { }
        Column { }
      }
    }
  }
}