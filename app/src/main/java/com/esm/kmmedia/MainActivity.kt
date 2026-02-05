package com.esm.kmmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.esm.kmmedia.ui.theme.KMMediaTheme
import com.esm.media_core.ui.VideoListScreen
import com.esm.media_core.util.AndroidMediaScanner

class MainActivity : ComponentActivity() {

    private val scanner by lazy { AndroidMediaScanner(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val videos = scanner.scanVideos()

            VideoListScreen(
                        videos = videos,
                        onVideoClick = { video ->
                            println("Playing: ${video.path}")
                        }
                    )

            }

    }
}
