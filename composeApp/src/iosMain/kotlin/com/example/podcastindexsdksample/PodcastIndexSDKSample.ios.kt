package com.example.podcastindexsdksample

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.engine.darwin.DarwinClientEngineConfig

actual fun defaultEngineFactory(): HttpClientEngineFactory<*> = Darwin

actual fun HttpClientConfig<*>.httpClientConfig() {
    engine {
        (this as DarwinClientEngineConfig).apply {
            configureRequest {

            }
        }
    }
}
