package zeng.qiang.wanandroid.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.entity.ArticleEntity
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
                ArticleItem(it)
            }
        }


    }
}


@Composable
fun ArticleItem(articleEntity: ArticleEntity) {
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
        Row {
            // Basic
            Image(
                painter = rememberImagePainter(articleEntity.envelopePic),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = articleEntity.title,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
            )
        }

    }

}