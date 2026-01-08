package one.nfolio.feever.iosNotifier

import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration

object NotifierManager {
  fun initialize() {
    NotifierManager.initialize(
      NotificationPlatformConfiguration.Ios(
        showPushNotification = true,
        askNotificationPermissionOnStart = true,
        notificationSoundName = null
      )
    )
  }
}