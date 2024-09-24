package com.example.podcastindexsdksample

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PodcastIndexSDKSample",
    ) {
        App()
    }
}