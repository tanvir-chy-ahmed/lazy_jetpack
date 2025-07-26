package com.tax.visa.uiintroduction.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun NetworkImage() {

    val imageUrl = "https://repository-images.githubusercontent.com/302800491/44604f00-0b00-11eb-8160-9e389c61d28d"

    var imageState by remember { mutableStateOf<AsyncImagePainter.State>(AsyncImagePainter.State.Empty) }

    AsyncImage(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp)),
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .build(),
        contentDescription = null,
        onState = { state -> imageState = state }
    )

    when (imageState) {
        is AsyncImagePainter.State.Loading -> {
            // Show loading spinner while image loads
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .size(200.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is AsyncImagePainter.State.Error -> {
            // Show error placeholder if image failed
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .size(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                // You can replace with your own error image or icon
                Text("Failed to load image")
            }
        }

        else -> {
            // Do nothing or show the loaded image (already displayed by AsyncImage)
        }
    }


}

