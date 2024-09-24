package com.example.podcastindexsdksample

import com.mr3y.podcastindex.PodcastIndexClient

fun initializeClient(): PodcastIndexClient {
    val client = PodcastIndexClient(BuildConfig.API_KEY, BuildConfig.API_SECRET, "PodcastIndexSample/1.1") {
        enableLogging = true
    }
    return client
}
