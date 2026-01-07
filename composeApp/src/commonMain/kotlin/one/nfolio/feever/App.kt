package one.nfolio.feever

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feever.composeapp.generated.resources.Manrope
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import feever.composeapp.generated.resources.Res
import feever.composeapp.generated.resources.nullIcon
import org.jetbrains.compose.resources.Font

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
      val headerRadius = 10.dp
      val manrope = Res.font.Manrope

      Column(
        modifier = Modifier
          .background(
            color = Color.White,
            shape = RoundedCornerShape(
              bottomStart = headerRadius,
              bottomEnd = headerRadius
            )
          )
      ) { // header

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
          // .border(width = 2.dp, color = Color.Black)
        ) {
          Text(
            text = "Feever",

          )
        }

        Row(
          modifier = Modifier
            .padding(start = headerRadius, end = headerRadius)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
          horizontalArrangement = Arrangement.Center
        ) {
          val feedNames = remember {
            TestFeedConfigurator.getAllName()
          }

          var count = 0
          feedNames.forEach { feedBName ->
            val startPadding = 0.dp
            var endPadding = 30.dp

            if(count == feedNames.size - 1) {
              endPadding = 0.dp
            } else if(count == 0) {
              AddFeedMenuItem("All", startPadding, endPadding, FontFamily(Font(manrope)))
            }

            AddFeedMenuItem(feedBName, startPadding, endPadding, FontFamily(Font(manrope)))
            count++
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

@Composable
fun AddFeedMenuItem(text: String, startPadding: Dp, endPadding: Dp, fontFamily: FontFamily) {
  Column(
    modifier = Modifier
      .padding(start = startPadding, end = endPadding),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painterResource(Res.drawable.nullIcon),
      modifier = Modifier
        .size(80.dp)
        .clip(CircleShape),
      contentDescription = text
    )
    Text(
      text = text,
      modifier = Modifier
        .drawBehind {
          drawLine(
            color = Color.Red,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 2.dp.toPx()
          )
        },
      fontSize = 18.sp,
      fontWeight = FontWeight(800),
      fontFamily = fontFamily
    )
  }
}
