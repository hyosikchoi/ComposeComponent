package com.hyosik.composecomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyosik.composecomponent.ui.component.*
import com.hyosik.composecomponent.ui.layout.*
import com.hyosik.composecomponent.ui.model.ItemData
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ReposScreen()
                }

            }
        }
    }
}
/** viewModel 에서는 remember 를 사용하지 않는다. */
/** remember 는 Composable 의 수명주기에 맞추기 위함이기 때문이다. */
class ToDoViewModel : ViewModel() {
//    val text = mutableStateOf("")
    private val _text = MutableLiveData("")
    val text: LiveData<String> get() = _text
    val setText: (String) -> Unit = {
        _text.value = it
    }

//    val toDoList = mutableStateListOf<ToDoData>()
    private val _rawToDoList = mutableListOf<ToDoData>()
    private val _toDoList = MutableLiveData<List<ToDoData>>(_rawToDoList)
    val toDoList: LiveData<List<ToDoData>> get() = _toDoList
    /** mutableStateListOf - 추가,삭제,대입 -> UI 가 갱신이 됩니다. 각 항목의 필드가 바뀌엇을 때 -> 갱신이 안되는 문제. */
    /** LiveData<List<X>>.observeAsState() - List 가 통채로 다른 List로 바뀌었을 때만 State가 갱신된다. */
    /** 그러므로 LiveData 를 이용해서 리스트를 다루면서 State 로 바꾸는 것은 좀 비효율 적이다. */
   val onSubmit: (String) -> Unit = {
        val key = (_rawToDoList.lastOrNull()?.key ?: 0) + 1
        _rawToDoList.add(ToDoData(key = key, text = it))
        _toDoList.value = _rawToDoList.toMutableList()
        _text.value = ""
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[i] = _rawToDoList[i].copy(done = checked)
        _toDoList.value = _rawToDoList.toMutableList()
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList.removeAt(i)
        _toDoList.value = _rawToDoList.toMutableList()
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[i] = _rawToDoList[i].copy(key = key, text = text)
        _toDoList.value = _rawToDoList.toMutableList()
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopLevel(viewModel: ToDoViewModel = viewModel()) {

    Scaffold {
        Column {
            ToDoInput(
                text = viewModel.text.observeAsState("").value,
                onTextChange = viewModel.setText,
                onSubmit = viewModel.onSubmit
            )
            // 단계 3: `LazyColumn`으로 `toDoList`를 표시합시다.
            /** `key`를 `toDoData`의 `key`를 사용합니다. */
            /** diffUtil 에서의 areItemSame 과 비슷하다고 볼 수 있다. */
            // LazyColumn items 내부에서는 Composable 함수인 observeAsState 를 사용할 수 없으므로 밖에서 변수로 빼서 사용한다.
            val items: List<ToDoData> = viewModel.toDoList.observeAsState(emptyList()).value
            LazyColumn {
                items(items, key = {it.key}) { todoData: ToDoData ->
                    ToDo(
                        toDoData = todoData,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete,
                        onEdit = viewModel.onEdit
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposeComponentTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp
    ) {

        // 단계 1: `Row`를 만들고 `toDoData.text`를 출력하고
        // 완료를 체크하는 체크박스, 수정 버튼, 삭제 버튼을 만드세요.
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                modifier = Modifier.weight(1f),
//                text = toDoData.text
//            )
//            Text(
//                text = "완료"
//            )
//            Checkbox(checked = toDoData.done, onCheckedChange = { checked -> onToggle(toDoData.key, checked)})
//            Button(onClick = {}) {
//                Text(text = "수정")
//            }
//            Spacer(modifier = Modifier.size(4.dp))
//            Button(onClick = {}) {
//                Text(text = "삭제")
//            }
//        }

        // 단계 2: `Crossfade`를 통해 `isEditing`을 따라 다른
        // UI를 보여줍니다. `OutlinedTextField`와 `Button을
        // 넣어봅시다.
        Crossfade(targetState = isEditing) {
            when(it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = toDoData.text
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(checked = toDoData.done, onCheckedChange = { checked -> onToggle(toDoData.key, checked)})
                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text(text = "수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onDelete(toDoData.key)
                        }) {
                            Text(text = "삭제")
                        }
                    }
                }

                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        val (newText, setNewText) = remember { mutableStateOf(toDoData.text) }

                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(
                            onClick = {
                                onEdit(toDoData.key, newText)
                                isEditing = false
                        }) {
                            Text(text = "완료")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposeComponentTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)


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

/* ============================================================================ */

@Composable
fun ReposScreen(viewModel: GithubViewModel = viewModel()) {
    LazyColumn{
        
        item { 
            Button(onClick = {
                viewModel.getRepos()
            }) {
                Text(text = "레포지토리 가져오기")
            }
        }
        
        items(viewModel.repos) {repo ->
             Text(repo.name)       
        }
    }
}

