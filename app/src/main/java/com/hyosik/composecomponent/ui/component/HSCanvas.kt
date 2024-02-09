package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HSCanvas() {
    Canvas(modifier = Modifier.size(200.dp)) {
        // drawLine 은 시작지점 offset, 끝지점 offset 을 입력해준다.
        drawLine(Color.Red, Offset(10f,10f), Offset(20f,20f))

        // drawCircle 은 색상, 반지름 , 원점의 위치를 지정한다.
        drawCircle(Color.Yellow, 10f, Offset(15f, 30f))

        // drawRect 는 색상 , 왼쪽 위 꼭지점 시작위치 , x,y 사이즈를 지정.
        drawRect(Color.Magenta, Offset(30f,30f), Size(10f,10f))

        // Icons.Filled.Send 를 들어가보면 materialPath 를 이용해서 라인을 이어놓은게 있다.
//        materialPath {
//            moveTo(2.01f, 21.0f)
//            lineTo(23.0f, 12.0f)
//            lineTo(2.01f, 3.0f)
//            lineTo(2.0f, 10.0f)
//            lineToRelative(15.0f, 2.0f)
//            lineToRelative(-15.0f, 2.0f)
//            close()
//        }

        // drawLine 을 이용해서 위의 좌표들을 계속해서 이어서 그리게끔 해본다.
        drawLine(Color.Green, Offset(2.01f,21.0f) , Offset(23.0f,12.0f))
        drawLine(Color.Green, Offset(23.0f,12.0f) , Offset(2.01f,3.0f))
        drawLine(Color.Green, Offset(2.01f,3.0f) , Offset(2.0f,10.0f))
        drawLine(Color.Green, Offset(2.0f,10.0f) , Offset(17.0f,12.0f)) // + 15 , + 2
        drawLine(Color.Green, Offset(17.0f,12.0f) , Offset(2.0f,14.0f)) // - 15 , + 2
        drawLine(Color.Green, Offset(2.0f,14.0f) , Offset(2.01f,21.0f)) // close 는 다시 처음 위치로

    }
}