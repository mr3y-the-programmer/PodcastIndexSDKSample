package com.example.podcastindexsdksample

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import okhttp3.OkHttpClient

actual fun defaultEngineFactory(): HttpClientEngineFactory<*> = OkHttp

actual fun HttpClientConfig<*>.httpClientConfig() {
    engine {
        (this as OkHttpConfig).apply {
            preconfigured = OkHttpClient()
            config {
                retryOnConnectionFailure(true)
            }
        }
    }
}
