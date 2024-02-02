package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HSBoxWithConstraints(modifier: Modifier) {
    // BoxWithConstraint 는 min,max width 의 제약을 받을 수 있다.
    // 매개변수로 받은 modifier 관련해서도 chaining 형식으로 더 선언할 수 있다.
    BoxWithConstraints(
        modifier = modifier
    ) {
        // 조건문 삽입으로 특정 width, height 일 때 컴포넌트 삽입 가능
        if(maxWidth > 120.dp) Text(text = "까꿍", modifier = Modifier.align(Alignment.TopStart))
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "maxW: $maxWidth maxH: $maxHeight minW: $minWidth minH: $minHeight",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}