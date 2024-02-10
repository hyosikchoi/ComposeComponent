package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme

@Composable
fun HSDropDown() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Box {
            Button(onClick = { expandDropDownMenu = true }) {
                Text("드롭다운 메뉴 열기")
            }
            // 단계 1: `DropdownMenu`를 만들고 `expanded`를 `expandDropDownMenu`로
            // 등록합시다.
            // `onDismissRequest`에 대해서는 `expandDropDownMenu`를 `false`로 바꿉니다.
            DropdownMenu(
                expanded = expandDropDownMenu,
                onDismissRequest = { expandDropDownMenu = false },
            ) {
                DropdownMenuItem(
                    onClick = {
                        counter++
                    }) {
                    Text(text = "증가")
                }
                DropdownMenuItem(
                    onClick = {
                        counter--
                    }) {
                    Text(text = "감소")
                }
            }
            // 단계 2: 두개의 `DropdownMenuItem`을 등록합시다. `onClick`을 구현하고
            // 내용물은 `Text`로 채워봅시다.
        }
        Text("카운터: $counter")
    }
}

@Preview(showBackground = true)
@Composable
fun HSDropDownPreview() {
    ComposeComponentTheme {
        HSDropDown()
    }
}