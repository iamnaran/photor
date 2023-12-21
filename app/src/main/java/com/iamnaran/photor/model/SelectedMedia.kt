package com.iamnaran.photor.model

import androidx.compose.ui.graphics.painter.Painter

// to identify images for displaying
enum class ImageIndex{
    UNKNOWN,
    FIRST_INDEX,
    SECOND_INDEX
}

data class SelectedMedia (val imageIndex: ImageIndex, val image:Painter)
