package com.iamnaran.photor

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val selectedImages = mutableStateListOf<Uri>()
    val allImagesList = mutableStateListOf<Uri>()
}