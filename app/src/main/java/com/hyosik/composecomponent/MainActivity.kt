package com.hyosik.composecomponent

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.hyosik.composecomponent.ui.component.*
import com.hyosik.composecomponent.ui.layout.*
import com.hyosik.composecomponent.ui.model.ItemData
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HSDialog()
                }

            }
        }
    }
}


@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentDescription = itemData.title
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.description)
        }
    }
}


@Composable
fun CatalogEx(itemList: List<ItemData>) {
    // LazyColumn 의 items 에 itemList 를 주입시켜 RecyclerView 와 같은 리스트를 그린다.
    LazyColumn {
        items(items = itemList) {item ->
            Item(itemData = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    ComposeComponentTheme {
        Item(
            itemData = ItemData(
                imageId = R.drawable.broly,
                title = "브로리",
                description = "드래곤볼 슈퍼 브로리 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        CatalogEx(items)
    }
}


val items = listOf<ItemData>(
    ItemData(
        imageId = R.drawable.broly,
        title = "브로리",
        description = "드래곤볼 슈퍼 브로리 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    ItemData(
        imageId = R.drawable.broly,
        title = "손오공",
        description = "드래곤볼 손오공 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    ItemData(
        imageId = R.drawable.broly,
        title = "베지터",
        description = "드래곤볼 베지터 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    ItemData(
        imageId = R.drawable.broly,
        title = "크리링",
        description = "드래곤볼 크리링 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    )
)


@Preview(showBackground = true)
@Composable
fun ConstraintPreview() {
    ComposeComponentTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HSConstraintLayout()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintChainPreview() {
    ComposeComponentTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HSConstraintLayoutChain()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardExPreview() {
    ComposeComponentTheme() {
        Surface(
        ) {
            HSCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CanvasPreview() {
    ComposeComponentTheme() {
        Surface(
        ) {
            HSCanvas()
        }
    }
}

