package com.hyosik.composecomponent.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HSTopAppBar() {
    Column {

        // navigationIcon 에 IconButton 을 만들고 자식으로 Icon을 넣습니다.
        // actions 를 이용해서 다른 action도 정의한다.
        TopAppBar(
            title = { Text(text = "TopAppBar")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "설정"
                    )
                }
            }
        )

        // 정해진 틀이 아닌 순서대로 컴포넌트를 채우는 TopAppBar 방법
        /** 하지만 일일히 간격을 내가 조정해야 하므로 차라리 정해진 틀로 사용하는게 편하다. */
        TopAppBar {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "업 네비게이션"
                )
            }
            // 남는 여백을 텍스트로 채우기 위해 layout weight 를 준다.
            Text(text = "TopAppBar", modifier = Modifier.weight(1f))

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "검색"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "설정"
                )
            }
        }

        
    }
}