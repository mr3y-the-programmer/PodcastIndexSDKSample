package com.example.podcastindexsdksample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform