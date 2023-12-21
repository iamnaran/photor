package com.iamnaran.photor.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppOutlineButton(title: String, onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }, modifier = Modifier.padding(8.dp)) {
        Text(title)
    }
}