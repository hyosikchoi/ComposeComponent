package com.hyosik.composecomponent.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HSScaffold() {

    var checked by remember {
        mutableStateOf(false)
    }
    /** 화면의 전체 구조를 사용할 수 있는 api 를 제공합니다. */
    /** topBar, floatActionButton 등등 화면의 구성 요소들 을 사용할 수 있게 함으로 써 화면 마다 처음에 scaffold 로 감싸는 걸 추천 합니다. */
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(imageVector = Icons.Filled.ArrowBack, contentDescription = "뒤로 가기")
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                }
            )
        }
    ) {
        CheckboxWithSlot(checked = checked , onCheckedChange = { checked = !checked }) {
            Text(text = "컴포즈를 좋아합니다.")
        }
    }



}