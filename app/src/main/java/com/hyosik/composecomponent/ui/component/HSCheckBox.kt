package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HSCheckBox() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // checked 의 상태가 바뀌게 하지 않으면 체크상태의 ui 가 절대 변하지 않는다.
        // var checked = true 로 지정하고 일반 변수로 사용해도 ui는 변하지 않는다.
        /** compose 에서는 리컴포지션이 일어나면서 ui 랜더링이 변하는건 상태 변수(mutalbeStateOf)가 변해야 한다. */
        /** remember 를 사용하는 이유는 리컴포지션이 언제 일어나면서 mutableStateOf 가 사라질지 모르기 때문 */
        /** delegate 패턴을 사용하면 remember 에게 위임해 마치 property 로 사용하게끔 가능하게 한다. .value 를 사용 안해도 된다. */
//        var checked = remember { mutableStateOf(false) }
//        Checkbox(checked = checked.value, onCheckedChange = { checked.value = !checked.value })
        var checked by remember { mutableStateOf(false) }
        Checkbox(checked = checked, onCheckedChange = { checked = !checked })
        Text(text = "프로그래머입니까?")
        /** 비구조화로 사용해보기 */
        // var (a,b) = listOf(2,3) 리스트를 a,b 와 같은 형태로 비구조화를 해서 사용한다.
        val (getter, setter) = remember{ mutableStateOf(false)}
        Checkbox(checked = getter, onCheckedChange = setter)

        // text 클릭 시 체크박스 상태 바꾸게 하기
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable { setter(!getter) }
        )
    }
}