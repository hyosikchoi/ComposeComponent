package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HSButton(
    onButtonClicked: () -> Unit
)  {
    // 버튼 안에 Icon 을 Text 앞에 추가시킬 수 있다.
    // icon 에서 contentDescription 은 Text 컴포넌트와 같은 역할을 한다.
    // border, shape 설정
    // contentPadding 설정
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(width = 10.dp, Color.Magenta),
        shape = RoundedCornerShape(size = 10.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}