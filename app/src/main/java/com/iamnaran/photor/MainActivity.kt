package com.iamnaran.photor

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iamnaran.photor.component.AppBar
import com.iamnaran.photor.component.AppOutlineButton
import com.iamnaran.photor.component.TriangularImageList
import com.iamnaran.photor.ui.theme.PhotorTheme
import com.iamnaran.photor.utils.TriangularNumberUtils


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppBar()
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RequestPermission(mainViewModel)
                    }
                }

            }

        }
    }

}



@Composable
fun RequestPermission(mainViewModel: MainViewModel) {

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents(),
        onResult = { uris ->
            mainViewModel.selectedImages.clear()
            uris.take(2).forEach { uri ->
                val allImages = TriangularNumberUtils.generateTriangularSequence(50, uris)
                mainViewModel.selectedImages.addAll(allImages)
            }
        }
    )

    Column() {
        AppOutlineButton("Pick Images") { galleryLauncher.launch("image/*") }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Recent Images", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        TriangularImageList(viewModel = mainViewModel)

    }

}

