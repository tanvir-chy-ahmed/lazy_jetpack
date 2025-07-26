package com.tax.visa.uiintroduction.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.tax.visa.uiintroduction.data.model

import androidx.compose.ui.unit.dp
import com.tax.visa.uiintroduction.data.list

@Composable
fun LazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
    ) {
        itemsIndexed(list.items)
        { index, item ->

            ColItem(item = item)
            Spacer(modifier.height(20.dp))

        }
    }
}


@Composable
fun ColItem(item: model) {

    Column(
        Modifier
            .padding(top = 50.dp)
            .height(200.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
            shape = CardDefaults.shape
        ) {


            var imageState by remember { mutableStateOf<AsyncImagePainter.State>(AsyncImagePainter.State.Empty) }

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(20.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
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
        Text(item.title, style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        ))




    }
}