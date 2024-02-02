package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HSModifier() {
    // button 의 컬러를 바꾸려면 background 가 아닌 button 의 colors 를 이용해야한다.
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan
        ),
        modifier = Modifier.padding(10.dp),
        enabled = false
    ) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = "Search",
            modifier = Modifier.clickable {}.offset(x= 10.dp)
        )
    }

}