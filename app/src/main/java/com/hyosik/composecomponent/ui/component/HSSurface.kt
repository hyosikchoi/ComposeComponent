package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HSSurface() {
    // Surface 에는 elevation 효과를 주면서 그림자 효과를 줄 수 있다.
    // border 도 설정 할 수 있다.
    // shape 를 통해 모양도 설정할 수 있다.
    // contentColor 가 자동으로 지정 됩니다. (error 선택시 onError로 contentColor는 지정)
    Surface(
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        shape = CircleShape,
        color = MaterialTheme.colors.error
    ) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(8.dp)
        )
    }
}