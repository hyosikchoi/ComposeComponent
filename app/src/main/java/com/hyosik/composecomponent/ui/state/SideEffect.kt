package com.hyosik.composecomponent.ui.state

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EffectEx(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    val scaffoldState = rememberScaffoldState()

    // 단계 1: `LaunchedEffect`을 이용해서 스낵바를 이용해 봅시다.
    // 파라미터에는 `scaffoldState.snackbarHostState`를 전달합시다.
    // "헬로 컴포즈"라고 출력합시다.
    // `LaunchedEffect`는 `CouroutineScope`를 만들기 때문에 스코프를 별도로
    // 만들 필요는 없습니다.
    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
        scaffoldState.snackbarHostState.showSnackbar(message = "헬로 컴포즈")
    }

    // 단계 2: `DisposableEffect`를 호출하고 파리미터로 `lifecycleOwner`를
    // 전달합니다.

    // `LifecycleEventObserver`를 상속받고 두 상태에 대해 로그를 남깁니다.
    // `Lifecycle.Event.ON_START`, `Lifecycle.Event.ON_STOP`

    // 블록 내에서 `lifecycleOwner.lifecycle.addObserver`로 옵저버를 추가하고
    // onDispose에서 옵저버를 제거합니다.
    DisposableEffect(key1 = lifecycleOwner) {
        // 할당
        val observer = LifecycleEventObserver { _, event ->
            // SAM: Single Abstract Method
            when(event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("이펙트", "ON_START ")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("이펙트", "ON_STOP ")
                }
                else -> {
                    Log.d("이펙트", "그 외 ")
                }
            }

        }

        lifecycleOwner.lifecycle.addObserver(observer)

        // 해제
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun EffectExDefaultPreview() {
    ComposeComponentTheme {
        EffectEx()
    }
}