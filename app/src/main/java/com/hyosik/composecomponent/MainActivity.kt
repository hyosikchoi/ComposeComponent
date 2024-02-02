package com.hyosik.composecomponent

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyosik.composecomponent.ui.component.HSButton
import com.hyosik.composecomponent.ui.component.HSModifier
import com.hyosik.composecomponent.ui.component.HSSurface
import com.hyosik.composecomponent.ui.component.HSText
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
                HSButton(onButtonClicked = {
                    Toast.makeText(this, "Send clicked", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        Column() {
            HSBoxWithConstraints(
                modifier = Modifier
                    .width(200.dp)
                    .height(250.dp)
                    .widthIn(min = 100.dp, max = 350.dp)
                    .heightIn(min = 50.dp)
            )
            HSBoxWithConstraints(
                modifier = Modifier
                    .width(150.dp)
                    .widthIn(min = 100.dp, max = 350.dp)
                    .heightIn(min = 50.dp)
            )
        }

    }
}