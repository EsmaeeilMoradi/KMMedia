package com.esm.media_core.player

interface VideoController {
    fun prepare(url: String)
    fun play()
    fun pause()
    fun release()
}