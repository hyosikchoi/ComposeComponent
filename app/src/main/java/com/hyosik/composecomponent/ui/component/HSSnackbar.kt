package com.hyosik.composecomponent.ui.component

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HSSnackbar() {
    var counter by remember { mutableStateOf(0) }

    // 단계 3: couroutineScope를 만듭시다.
    // `rememberCoroutineScope`를 사용합니다.
    val coroutineScope = rememberCoroutineScope()

    // 단계 1: scaffoldState를 만들고 Scaffold에 설정합시다.
    // scaffoldState를 만들기 위해 `rememberScaffoldState`를 사용합니다.
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {

        // Composable 안에서 바로 SnackBar 를 실행 시키려면 LaunchedEffect 와 같은 사이드 이펙트를 사용해야 한다.
        // LaunchedEffect 는 useEffect 와 같이 특정 키값이 변경 되면 호출되거나 키 값이 없다면 처음 한번 호출 된다.
        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
            coroutineScope.launch {
                // SnackBar result 를 받을 수 있다.
                val result: SnackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )

                when(result) {
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> {}
                }
            }
        }

        // 단계 2: "더하기" 버튼을 만들어 봅시다.
        // action에서 counter를 증가시킵시다.    
        Button(onClick = { 
            counter++
            coroutineScope.launch {
                // SnackBar result 를 받을 수 있다.
                val result: SnackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )

                when(result) {
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> {}
                }
            }
        }) {
            Text(text = "더하기")
        }
        // 단계 4: 버튼의 onClick에서 `coroutineScope.launch`를
        // 사용합니다.

        // 단계 5: 스낵바를 사용하기 위해 `scaffoldState.snackbarHostState.showSnackbar`
        // 사용합니다.

        // `message`에 카운터를 출력합시다.
        // `actionLabel`를 "닫기"로 지정합시다.
        // `duration`에 `SnackbarDuration.Short`를 사용합니다.
    }
}

@Preview(showBackground = true)
@Composable
fun HSSnackbarPreview() {
    ComposeComponentTheme {
        HSSnackbar()
    }
}