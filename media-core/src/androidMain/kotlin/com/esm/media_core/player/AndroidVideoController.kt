package com.esm.media_core.player


import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class AndroidVideoController(
    private val context: Context
) : VideoController {

    // این همان شیئی است که باید به UI اندروید پاس بدهیم
    val exoPlayer: ExoPlayer by lazy {
        ExoPlayer.Builder(context).build()
    }

    override fun prepare(url: String) {
        val mediaItem = MediaItem.fromUri(url)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun play() { exoPlayer.play() }
    override fun pause() { exoPlayer.pause() }
    override fun release() { exoPlayer.release() }
}