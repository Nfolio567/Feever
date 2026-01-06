package one.nfolio.feever

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform