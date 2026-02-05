package com.esm.media_core.model
data class MediaVideo(
    val id: Long,
    val uriString: String,
    val size: Long,
    val width: Int,
    val height: Int,
    val path: String,
    val duration: Long,
    val dateModified: Long,
    val thumbnailPath: String? = null
)