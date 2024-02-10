package com.hyosik.composecomponent.ui.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme

@Composable
fun PyeongToSquareMeter() {
    /** remember vs rememberSaveable */
    /** remember 는 configuration 이 변경될 때 저장되지 않습니다. */
    /** 대표적인 예로 Rotation 이 일어날 경우 혹은 language 가 변경될 때 입니다. */
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }
    // StateHoisting 개념
    /** 가능하면 state 는 위로 올려서 컨트롤 가능하게 하고 UI부분은 Stateless 하게 만드는 것이 좋다.  */
    /** 상단에서 여러개의 Stateless 한 composable 을 다루게 한다. */


    // 단계 1: remember를 이용해 상태를 만들고 평 값을 입력하면
    // 제곱미터가 출력되도록 화면을 구성하시오.
    // 평을 제곱미터로 바꾸기 위해서는 3.306을 곱하면 됩니다.
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//
//                if(it.isBlank()) {
//                    pyeong = ""
//                    squaremeter = ""
//                    return@OutlinedTextField
//                }
//
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField // 숫자가 아닌 a 와 같은 문자 입력시 막음.
//                pyeong = it
//                squaremeter = (numericValue * 3.306).toString()
//            }, label = {
//                Text("평")
//            }
//        )
//        OutlinedTextField(
//            value = squaremeter,
//            onValueChange = {},
//            label = {
//                Text("제곱미터")
//            }
//        )
//    }

    // 단계 2: `Composable` 함수를 만들고 `Column`의 항목들을 옮기세요.
    // 단 상태는 옮기지 말아야 합니다.

    // 파라미터는 아래와 같이 구성합니다.
    // `pyeong: String, squareMeter: String, onPyeongChange: (String) -> Unit`
    PyeongToSquareMeterStateless(
        pyeong = pyeong,
        squareMeter = squaremeter
    ) {
        if (it.isBlank()) {
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue =
            it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless // 숫자가 아닌 a 와 같은 문자 입력시 막음.
        pyeong = it
        squaremeter = (numericValue * 3.306).toString()
    }
}

@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = {
                onPyeongChange
            }, label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PyeongToSquareMeterPreview() {
    ComposeComponentTheme {
        PyeongToSquareMeter()
    }
}