package zeng.qiang.wanandroid.ui.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.entity.ArticleEntity

@ExperimentalSerializationApi
@Composable
fun ArticleDetailPage(articleEntity: ArticleEntity) {

    LazyColumn {
        item {
            Text(text = articleEntity.toString())
        }


    }
}