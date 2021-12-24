package zeng.qiang.wanandroid.entity

import kotlinx.serialization.Serializable

@Serializable
data class PageEntity<T>(
    val curPage: Int,
    val datas: List<T>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
