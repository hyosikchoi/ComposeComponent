package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HSTextField() {
    Column(modifier = Modifier.padding(16.dp)) {

        var name by remember {
            mutableStateOf("Tom")
        }

        /** label 속성으로  어떤 값을 넣을건지 타이틀을 달 수 있다. */
        TextField(
            value = name,
            label = {
             Text(text = "이름")
            },
            onValueChange = { name = it }
        )
        
        Text(text = name)

        Spacer(modifier = Modifier.size(20.dp))

        /** 바깥 테두리만 있는 TextField 생성 (OutlinedButton 도 있음 )*/
        OutlinedTextField(
            value = name,
            onValueChange = {name = it}
        )

    }
}