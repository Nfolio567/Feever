package one.nfolio.feever

import com.mmk.kmpnotifier.notification.NotifierManager

object Initialize {
  fun init() {
    NotifierManager.addListener(object : NotifierManager.Listener {
      override fun onNewToken(token: String) {
        println("Device Token: $token")
      }
    })
  }
}