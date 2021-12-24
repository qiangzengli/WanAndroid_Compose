package zeng.qiang.wanandroid.ui.page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.entity.ArticleEntity
import zeng.qiang.wanandroid.entity.PageEntity
import zeng.qiang.wanandroid.net.api

class MainViewModel : ViewModel() {
    var liveData = MutableLiveData<PageEntity<ArticleEntity>>()
    @ExperimentalSerializationApi
    fun initData() {
        viewModelScope.launch {
            try {
                val res = api.getWxArticle(0)

                liveData.value = res.data
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }


    }
}