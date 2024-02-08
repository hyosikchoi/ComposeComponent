package com.hyosik.composecomponent.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HSConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // constraintLayout 에서는 createRefs() 를 만들어야 한다. 컴포넌트간 배치 관계 때문이다.
        // createRefs 는 복수 이므로 비구조화 를 통해 분해 합니다.
        // createRefs 를 타고 들어가면 컴포넌트를 16개까지 가질 수 있다.
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()


        // constraintAs 모디파이어를 추가하고 레퍼런스를 전달합니다.
        // constraintAs 람다 함수에서 lilnkTo 를 호출하여 해당 컴포넌트가 어디와 관계를 맺을지 지정합니다.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // top, bottom, start, end 모두 중앙에 연결하고 싶으면 linkTo 를 4번 쓸 필요없이 centerTo 를 사용한다.
        // centerHorizontallyTo 와 centerVerticallyTo 를 이용해서 top,bottom 중앙정렬 혹은 start,end 의 중앙정렬 처리를 할 수 있다.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    centerTo(parent)
                }
        )

        Box(
            modifier = Modifier.size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}