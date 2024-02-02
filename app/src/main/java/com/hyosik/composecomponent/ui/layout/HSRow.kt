package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HSRow() {
    // Row 는 가로방향으로 배치할 때 사용되는 레이아웃이다.
    // Row 에서 align 은 반대인 세로방향으로 설정만 가능하다.
    // Row 자식 뷰들의 전체 align 설정은 Row 에서 align 을 설정하면 된다.
    // ArrangeMent 는 수직 방향으로만 설정 가능
    // RowScope 내에서 modifier 에 weight 속성으로 LinearLayout 의 weight처럼 비율 설정 가능
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(40.dp)
    ) {
        Text(
            text = "첫 번째!",
            modifier = Modifier.align(Alignment.Top).weight(2f)
        )
        Text(
            text = "두 번째!",
            modifier = Modifier.align(Alignment.CenterVertically).weight(3f)
        )
        Text(
            text = "세 번째!",
            modifier = Modifier.align(Alignment.CenterVertically).weight(2f)
        )
    }
}