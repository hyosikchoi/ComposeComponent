package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

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

    /** 기본 제공하는 AlertDialog */
//    if(openDialog) {
//        AlertDialog(
//            // 외부에서 클릭이 일어났을 때
//            onDismissRequest = {
//                openDialog = false
//            },
//            // 확인 버튼 클릭 시
//            confirmButton = {
//               Button(onClick = {
//                   openDialog = false
//                   counter++
//               }) {
//                   Text(text = "더하기")
//               }
//            },
//            // 취소 버튼 클릭 시
//            dismissButton = {
//                Button(onClick = {
//                    openDialog = false
//                }) {
//                    Text(text = "취소")
//                }
//            },
//            title = {
//                Text(text = "더하기")
//            } ,
//            text = {
//                Text(text = "더하기 버튼을 누르면 카운터가 증가합니다. \n버튼을 눌러주세요.")
//            }
//        )
//    }

    /** CustomDialog */
    if(openDialog) {
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            /** dim 처리가 외부에만 적용 되게 하려면 Surface 로 감싸줘야 한다. */
            Surface(
                shape = RoundedCornerShape(3)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).wrapContentWidth()
                ) {
                    Text(text = "버튼을 클릭해주세요.\n* +1을 누르면 값이 증가됩니다.\n * -1을 누르면 값이 감소됩니다.")
                    Row(
                        modifier = Modifier.width(200.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text(text = "취소")                            
                        }
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text(text = "+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text(text = "-1")
                        }
                    }
                }
            }
        }
    }

}