package one.nfolio.feever

interface FeedConfigurator {
  fun registration(name: String, url: String)
  fun getAllName() : List<String>
}

object TestFeedConfigurator : FeedConfigurator {
  override fun registration(name: String, url: String) {
    TODO("Not yet implemented")
  }

  override fun getAllName(): List<String> {
    return listOf("feed0", "feed1", "feed2", "feed3", "feed4")
  }
}
