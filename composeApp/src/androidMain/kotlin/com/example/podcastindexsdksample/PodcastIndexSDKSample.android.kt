package com.example.podcastindexsdksample

import android.util.Log
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import io.ktor.client.engine.android.AndroidEngineConfig
import io.ktor.client.plugins.api.createClientPlugin

actual fun defaultEngineFactory(): HttpClientEngineFactory<*> = Android

@Suppress("UNCHECKED_CAST")
actual fun HttpClientConfig<*>.httpClientConfig() {
    (this as HttpClientConfig<AndroidEngineConfig>).apply {
        val logRequestsPlugin = createClientPlugin("logRequestsPlugin") {
            onRequest { _, _ ->
                Log.d("PodcastIndexSDKSample", "Engine used to make this request: ${this@createClientPlugin.client.engine}")
            }
        }
        install(logRequestsPlugin)
    }
    engine {
        this as AndroidEngineConfig

        connectTimeout = 100_000
        socketTimeout = 100_000
    }
}
