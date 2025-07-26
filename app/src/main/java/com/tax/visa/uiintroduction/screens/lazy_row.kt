package com.tax.visa.uiintroduction.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tax.visa.uiintroduction.data.list

@Composable
fun LazyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(list.items)
        { index, item ->

            SingleItem(item = item)
            Spacer(modifier.width(20.dp))

        }
    }
}


