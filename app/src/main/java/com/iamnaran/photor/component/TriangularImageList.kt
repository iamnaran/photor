package com.iamnaran.photor.component

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.iamnaran.photor.MainViewModel

@Composable
fun TriangularImageList(viewModel: MainViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 135.dp)
    ) {
        itemsIndexed(viewModel.selectedImages) { index, photo ->
            ImageComponent(photo,index)
        }
    }

}
