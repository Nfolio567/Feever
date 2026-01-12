package one.nfolio.feever.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object KtorClient {
  val client get() = HttpClient(CIO) {
    install(ContentNegotiation) {
      json()
    }
  }
}