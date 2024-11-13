package com.example.podcastindexsdksample

import com.mr3y.podcastindex.PodcastIndexClient
import com.mr3y.podcastindex.ktor3.PodcastIndexClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory

fun initializeClient(): PodcastIndexClient {
    val client = PodcastIndexClient(BuildConfig.API_KEY, BuildConfig.API_SECRET, "PodcastIndexSample/1.1") {
        enableLogging = true
        httpClient(defaultEngineFactory()) {
            httpClientConfig()
        }
    }
    return client
}

expect fun defaultEngineFactory(): HttpClientEngineFactory<*>

expect fun HttpClientConfig<*>.httpClientConfig()
