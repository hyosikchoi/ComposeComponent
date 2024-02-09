package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*

@Composable
fun HSDialog() {
    var openDialog by remember {
        mutableStateOf(false)
    }

    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = {openDialog = true }) {
            Text(text = "다이어로그 열기")
        }

        Text(text = "카운터: $counter")
    }

    if(openDialog) {
        AlertDialog(
            // 외부에서 클릭이 일어났을 때
            onDismissRequest = {
                openDialog = false
            },
            // 확인 버튼 클릭 시
            confirmButton = {
               Button(onClick = {
                   openDialog = false
                   counter++
               }) {
                   Text(text = "더하기")
               }
            },
            // 취소 버튼 클릭 시
            dismissButton = {
                Button(onClick = {
                    openDialog = false
                }) {
                    Text(text = "취소")
                }
            },
            title = {
                Text(text = "더하기")
            } ,
            text = {
                Text(text = "더하기 버튼을 누르면 카운터가 증가합니다. \n버튼을 눌러주세요.")
            }
        )
    }

}