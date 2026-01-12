package one.nfolio.feever

import com.mmk.kmpnotifier.notification.NotifierManager
import feever.composeapp.generated.resources.Res
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import one.nfolio.feever.httpClient.KtorClient


object Initialize {
  fun init() {
    NotifierManager.addListener(object : NotifierManager.Listener {
      override fun onNewToken(token: String) {
        //println("Device Token: $token")
        runBlocking {
          val json = Json { ignoreUnknownKeys = true }
          val serverLocation = json.decodeFromString<Config>(Res.readBytes("raw/config.json").toString()).serverLocation

          val res = KtorClient.client.post(serverLocation) {
            contentType(ContentType.Application.Json)
            setBody(CreateFCMRequest(token))
          }


        }
      }
    })
  }
}

@Serializable
data class Config(val serverLocation: String)

@Serializable
data class CreateFCMRequest(val token: String)
