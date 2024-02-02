package com.hyosik.composecomponent

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyosik.composecomponent.ui.component.*
import com.hyosik.composecomponent.ui.layout.HSBox
import com.hyosik.composecomponent.ui.layout.HSBoxWithConstraints
import com.hyosik.composecomponent.ui.layout.HSColumn
import com.hyosik.composecomponent.ui.layout.HSRow
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                HSCoilImage()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
//      Column {
//          // resource id 를 가져와서 세팅 하는법
//          Image(
//              painter = painterResource(id = R.drawable.broly),
//              contentDescription = "브로리"
//          )
//
//          // vector 이미지로 세팅하는법
//          // Filled 만 치고 엔터 눌러도 된다.
//          Image(
//              imageVector = Icons.Filled.Settings,
//              contentDescription = "세팅"
//          )
//      }
        HSCoilImage()
    }
}