package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HSColumn() {
    // Column 은 가로방향으로 배치할 때 사용되는 레이아웃이다.
    /** 한가지 주의할점 : Column 애서 alignment 는 Center 로 끝나는게 아닌 horizontally 혹은 vertically 가 붙어야한다.*/
    Column(
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center,
        modifier = Modifier.size(100.dp)
    ) {
        Text(text = "첫 번째", modifier = Modifier.align(Alignment.End))
        Text(text = "두 번째")
        Text(text = "세 번째", modifier = Modifier.align(Alignment.Start))
    }
}