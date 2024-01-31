package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HSText(name: String) {
    // 1. color 지정
//    Text(color = Color.Red , text = "Hello $name")

    // 2. color 객체로 해쉬값으로 지정 (ARGB)
//    Text(color = Color(0xffff9944) , text = "Hello $name")

    // fontsize, fontweight, fontfamily , letterSpacing(글자간 간격)
    // textDecoration (밑줄과 같은 옵션을 설정할 수 있다.)
    Text(
        modifier = Modifier.width(300.dp),
        text = "Hello $name\nHello $name\nHello $name\n",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
}