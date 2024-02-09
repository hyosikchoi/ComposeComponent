package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HSConstraintLayoutChain() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (redBox, yellowBox,magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )



        // createVerticalChain, createHorizontalChain 을 이용해서 세 박스의 레퍼런스를 연결
        // chainStyle 을 매개변수로 지정이 가능
//        createVerticalChain(redBox, yellowBox, magentaBox)
          createHorizontalChain(redBox,yellowBox,magentaBox, chainStyle = ChainStyle.Packed)

        // createBottomBarrier 를 생성하여 chain 으로 연결된 box 들의 하단에 배리어를 생성합니다.
        // 해당 배리어를 기점으로 배리어 아래에 Text 가 오게끔 만듭니다.
        val barrier = createBottomBarrier(redBox,yellowBox,magentaBox)
        Text(
            text = "나라말슴이 듕귁에 달아 나라말슴이 듕귁에 달아 나라말슴이 듕귁에 달아 나라말슴이 듕귁에 달아",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrier)
            }
        )
    }
}