package com.example.podcastindexsdksample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mr3y.podcastindex.model.PodcastFeed
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var isLoading by remember { mutableStateOf(true) }
        val client = remember { initializeClient() }
        var podcasts by remember { mutableStateOf(emptyList<PodcastFeed>()) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Searching for \"kotlin\" topic podcasts")

            LaunchedEffect(Unit) {
                podcasts = client.search.forPodcastsByTerm("kotlin").feeds
                isLoading = false
            }

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                podcasts.forEachIndexed { index, podcast ->
                    key(index) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = podcast.title)
                            Text(text = "By ${podcast.author}", color = MaterialTheme.colors.onSurface.copy(0.7f))
                        }
                    }
                }
            }
        }
    }
}
