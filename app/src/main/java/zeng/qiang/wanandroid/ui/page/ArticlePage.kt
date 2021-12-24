package zeng.qiang.wanandroid.ui.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.ui.theme.Pink

@ExperimentalSerializationApi
@Composable
fun ArticlePage(vm: MainViewModel = viewModel()) {
    vm.initData()
    val data = vm.liveData.observeAsState()
    val dataList = data.value?.datas ?: arrayListOf()

    LazyColumn {
        dataList.map {
            item {
                ArticleItem(name = it.title)
            }
        }


    }
}


@Composable
fun ArticleItem(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .clickable {
            },
        elevation = 0.dp,
        backgroundColor = Pink,
    ) {
        Text(
            text = "Hello ${name}!",
            modifier = Modifier.padding(10.dp),
        )
    }

}