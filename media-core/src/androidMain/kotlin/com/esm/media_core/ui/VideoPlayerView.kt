package com.esm.media_core.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import com.esm.media_core.player.AndroidVideoController

@Composable
fun VideoPlayerView(
    modifier: Modifier = Modifier,
    controller: AndroidVideoController
) {
    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                player = controller.exoPlayer
                useController = true // نمایش دکمه‌های Play/Pause پیش‌فرض
            }
        },
        modifier = modifier
    )
}