package com.esm.kmmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.esm.media_core.model.MediaVideo
import com.esm.media_core.player.AndroidVideoController
import com.esm.media_core.ui.VideoListScreen
import com.esm.media_core.ui.VideoPlayerView
import com.esm.media_core.util.AndroidMediaScanner

class MainActivity : ComponentActivity() {

    private val scanner by lazy { AndroidMediaScanner(this) }
    private val videoController by lazy { AndroidVideoController(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val videos = remember { scanner.scanVideos() }
            var selectedVideo by remember { mutableStateOf<MediaVideo?>(null) }

            BackHandler(enabled = selectedVideo != null) {
                videoController.pause()
                selectedVideo = null
            }

            if (selectedVideo == null) {
                VideoListScreen(
                    videos = videos,
                    onVideoClick = { video ->
                        selectedVideo = video
                        videoController.prepare(video.path)
                    }
                )
            } else {
                VideoPlayerView(
                    modifier = Modifier.fillMaxSize(),
                    controller = videoController
                )
            }
        }
    }
    override fun onPause() {
        super.onPause()
        videoController.pause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoController.release()
    }
}