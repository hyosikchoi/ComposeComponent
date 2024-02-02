package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HSBox() {
    // 안드로이드 FrameLayout 처럼 중첩시키는 용도로 사용 된다.
    // Box 중첩시 부모 Box의 modifier 설정을 제거하고 자식 Box의 사이즈를 조정하면 자식을 wrap으로 따라가게된다.
    // 자식 사이즈를 matchParentSize() 와 fillMaxSize() 로 비교해본다.
    Box {
        Box(modifier = Modifier.fillMaxSize().background(Color.Red))
        Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.Center))
        Text(text = "Hello World" , modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "JetPack" , modifier = Modifier.align(Alignment.TopStart))
    }
}