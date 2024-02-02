package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

@Composable
fun HSCoilImage() {
    Column() {
        // rememberImagePainter 는 Compose 한국어 문서에서 추천
        val painter = rememberImagePainter(data = "https://fastly.picsum.photos/id/283/200/300.jpg?hmac=HVbRBUPQVx2vypDRbrSdilx6LhDFbU9jsqNdlKR9J9I")
        Image(painter = painter, contentDescription = "페인터")

        AsyncImage(
            model = "https://fastly.picsum.photos/id/283/200/300.jpg?hmac=HVbRBUPQVx2vypDRbrSdilx6LhDFbU9jsqNdlKR9J9I",
            contentDescription = "픽섬"
        )
    }
}