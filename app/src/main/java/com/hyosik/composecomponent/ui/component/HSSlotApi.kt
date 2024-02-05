package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


/** 진정한 SlotApi 는 매개변수로 @Composable 을 넘겨주는 것이다. */
/** () -> Unit 의 익명 함수 형식으로 넘겨준다. */
/** 여기서 RowScope.() 형태로 넘겨주면 해당 람다식 안에서는 Row 의 속성으로 사용할 수 있다. ex. modifier = Modifier.align(Alignment.CenterVertically) */
@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    // Row 에만 clickable 을 넣고 checkbox에 넣지 않으면 checkbox 를 클릭 할 때 인식이 안된다.
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
        content()
    }
}


@Composable
fun HSSlotApi() {

    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

//    CheckboxWithSlot(checked = checked1) { Text(text = "텍스트 1", modifier = Modifier.align(Alignment.CenterVertically)) }
//    CheckboxWithSlot(checked = checked2) { Text(text = "텍스트 2") }

    Column {
        CheckboxWithSlot(checked = checked1, onCheckedChange = { checked1 = !checked1 }) { Text(text = "텍스트 1", modifier = Modifier.align(Alignment.CenterVertically)) }
        CheckboxWithSlot(checked = checked2 , onCheckedChange = { checked2 = !checked2 }) { Text(text = "텍스트 2") }

    }

}