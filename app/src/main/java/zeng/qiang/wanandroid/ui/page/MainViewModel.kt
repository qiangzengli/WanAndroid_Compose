package zeng.qiang.wanandroid.ui.page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.entity.ArticleEntity
import zeng.qiang.wanandroid.net.api

class MainViewModel(
    var liveData: MutableLiveData<ArticleEntity> = MutableLiveData<ArticleEntity>()
) : ViewModel(
) {
    @ExperimentalSerializationApi
    suspend fun initData() {
        flow {
            emit(api.getWxArticle(0))
        }.collect {
            liveData.value = it.data
        }


    }
}